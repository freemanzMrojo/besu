/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.tests.acceptance.dsl.privacy.web3j;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.besu.Besu;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.tx.ChainId;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.exceptions.ContractCallException;
import org.web3j.tx.response.TransactionReceiptProcessor;
import org.web3j.utils.Base64String;
import org.web3j.utils.Numeric;
import org.web3j.utils.Restriction;

public class TesseraTransactionManager extends TransactionManager {

  private final Besu besu;

  private final Credentials credentials;

  private final long chainId;

  private final TesseraBase64String privateFrom;

  private final List<TesseraBase64String> privateFor;
  private final Base64String privacyGroupId;

  private final Restriction restriction;

  public TesseraTransactionManager(
      final Besu besu,
      final Credentials credentials,
      final TransactionReceiptProcessor transactionReceiptProcessor,
      final long chainId,
      final TesseraBase64String privateFrom,
      final Base64String privacyGroupId,
      final Restriction restriction) {
    super(transactionReceiptProcessor, credentials.getAddress());
    this.besu = besu;
    this.credentials = credentials;
    this.chainId = chainId;
    this.privateFrom = privateFrom;
    this.privateFor = null;
    this.privacyGroupId = privacyGroupId;
    this.restriction = restriction;
  }

  public TesseraTransactionManager(
      final Besu besu,
      final Credentials credentials,
      final TransactionReceiptProcessor transactionReceiptProcessor,
      final long chainId,
      final TesseraBase64String privateFrom,
      final List<TesseraBase64String> privateFor,
      final Restriction restriction) {
    super(transactionReceiptProcessor, credentials.getAddress());
    this.besu = besu;
    this.credentials = credentials;
    this.chainId = chainId;
    this.privateFrom = privateFrom;
    this.privateFor = privateFor;
    this.privacyGroupId = PrivacyGroupUtils.generateLegacyGroup(privateFrom, privateFor);
    this.restriction = restriction;
  }

  @Override
  public EthSendTransaction sendTransaction(
      final BigInteger gasPrice,
      final BigInteger gasLimit,
      final String to,
      final String data,
      final BigInteger value,
      final boolean constructor)
      throws IOException {
    final BigInteger nonce =
        besu.privGetTransactionCount(credentials.getAddress(), privacyGroupId)
            .send()
            .getTransactionCount();

    final RawTesseraPrivateTransaction transaction;

    if (privateFor != null) {
      transaction =
          RawTesseraPrivateTransaction.createTransaction(
              nonce, gasPrice, gasLimit, to, data, privateFrom, privateFor, restriction);
    } else {
      transaction =
          RawTesseraPrivateTransaction.createTransaction(
              nonce, gasPrice, gasLimit, to, data, privateFrom, privacyGroupId, restriction);
    }

    return signAndSend(transaction);
  }

  @Override
  public EthSendTransaction sendEIP1559Transaction(
      final long chainId,
      final BigInteger maxPriorityFeePerGas,
      final BigInteger maxFeePerGas,
      final BigInteger gasLimit,
      final String to,
      final String data,
      final BigInteger value,
      final boolean constructor)
      throws IOException {
    final BigInteger nonce =
        besu.privGetTransactionCount(credentials.getAddress(), privacyGroupId)
            .send()
            .getTransactionCount();

    final RawTesseraPrivateTransaction transaction;
    if (privateFor != null) {
      transaction =
          RawTesseraPrivateTransaction.createTransaction(
              chainId,
              nonce,
              maxPriorityFeePerGas,
              maxFeePerGas,
              gasLimit,
              to,
              data,
              privateFrom,
              privateFor,
              restriction);
    } else {
      transaction =
          RawTesseraPrivateTransaction.createTransaction(
              chainId,
              nonce,
              maxPriorityFeePerGas,
              maxFeePerGas,
              gasLimit,
              to,
              data,
              privateFrom,
              privacyGroupId,
              restriction);
    }

    return signAndSend(transaction);
  }

  @Override
  public String sendCall(
      final String to, final String data, final DefaultBlockParameter defaultBlockParameter)
      throws IOException {
    final EthCall ethCall =
        besu.privCall(
                privacyGroupId.toString(),
                Transaction.createEthCallTransaction(getFromAddress(), to, data),
                defaultBlockParameter)
            .send();

    assertCallNotReverted(ethCall);
    return ethCall.getValue();
  }

  @Override
  public EthGetCode getCode(
      final String contractAddress, final DefaultBlockParameter defaultBlockParameter)
      throws IOException {
    return this.besu
        .privGetCode(privacyGroupId.toString(), contractAddress, defaultBlockParameter)
        .send();
  }

  public String sign(final RawTesseraPrivateTransaction rawTransaction) {
    final byte[] signedMessage;

    if (chainId > ChainId.NONE) {
      signedMessage = TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
    } else {
      signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
    }

    return Numeric.toHexString(signedMessage);
  }

  public EthSendTransaction signAndSend(final RawTesseraPrivateTransaction rawTransaction)
      throws IOException {
    final String hexValue = sign(rawTransaction);
    return this.besu.eeaSendRawTransaction(hexValue).send();
  }

  private static void assertCallNotReverted(final EthCall ethCall) {
    if (ethCall.isReverted()) {
      throw new ContractCallException(String.format(REVERT_ERR_STR, ethCall.getRevertReason()));
    }
  }
}
