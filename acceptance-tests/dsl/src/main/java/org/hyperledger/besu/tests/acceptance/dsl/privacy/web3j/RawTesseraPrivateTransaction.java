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

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.transaction.type.ITransaction;
import org.web3j.crypto.transaction.type.LegacyTransaction;
import org.web3j.crypto.transaction.type.Transaction1559;
import org.web3j.utils.Base64String;
import org.web3j.utils.Restriction;

public class RawTesseraPrivateTransaction extends RawTransaction {

  private final TesseraBase64String privateFrom;
  private final List<TesseraBase64String> privateFor;
  private final Base64String privacyGroupId;
  private final Restriction restriction;

  protected RawTesseraPrivateTransaction(
      final BigInteger nonce,
      final BigInteger gasPrice,
      final BigInteger gasLimit,
      final String to,
      final String data,
      final TesseraBase64String privateFrom,
      final List<TesseraBase64String> privateFor,
      final Base64String privacyGroupId,
      final Restriction restriction) {
    super(new LegacyTransaction(nonce, gasPrice, gasLimit, to, BigInteger.ZERO, data));
    this.privateFrom = privateFrom;
    this.privateFor = privateFor;
    this.privacyGroupId = privacyGroupId;
    this.restriction = restriction;
  }

  protected RawTesseraPrivateTransaction(
      final ITransaction transaction,
      final TesseraBase64String privateFrom,
      final List<TesseraBase64String> privateFor,
      final Base64String privacyGroupId,
      final Restriction restriction) {
    super(transaction);
    this.privateFrom = privateFrom;
    this.privateFor = privateFor;
    this.privacyGroupId = privacyGroupId;
    this.restriction = restriction;
  }

  protected RawTesseraPrivateTransaction(
      final RawTransaction rawTransaction,
      final TesseraBase64String privateFrom,
      final Base64String privacyGroupId,
      final Restriction restriction) {
    this(rawTransaction, privateFrom, null, privacyGroupId, restriction);
  }

  protected RawTesseraPrivateTransaction(
      final RawTransaction rawTransaction,
      final TesseraBase64String privateFrom,
      final List<TesseraBase64String> privateFor,
      final Restriction restriction) {
    this(rawTransaction, privateFrom, privateFor, null, restriction);
  }

  private RawTesseraPrivateTransaction(
      final RawTransaction rawTransaction,
      final TesseraBase64String privateFrom,
      final List<TesseraBase64String> privateFor,
      final Base64String privacyGroupId,
      final Restriction restriction) {
    this(rawTransaction.getTransaction(), privateFrom, privateFor, privacyGroupId, restriction);
  }

  public static RawTesseraPrivateTransaction createContractTransaction(
      final BigInteger nonce,
      final BigInteger gasPrice,
      final BigInteger gasLimit,
      final String init,
      final TesseraBase64String privateFrom,
      final Base64String privacyGroupId,
      final Restriction restriction) {

    return new RawTesseraPrivateTransaction(
        LegacyTransaction.createContractTransaction(
            nonce, gasPrice, gasLimit, BigInteger.ZERO, init),
        privateFrom,
        null,
        privacyGroupId,
        restriction);
  }

  public static RawTesseraPrivateTransaction createTransaction(
      final BigInteger nonce,
      final BigInteger gasPrice,
      final BigInteger gasLimit,
      final String to,
      final String data,
      final TesseraBase64String privateFrom,
      final List<TesseraBase64String> privateFor,
      final Restriction restriction) {

    return new RawTesseraPrivateTransaction(
        LegacyTransaction.createTransaction(nonce, gasPrice, gasLimit, to, data),
        privateFrom,
        privateFor,
        null,
        restriction);
  }

  public static RawTesseraPrivateTransaction createTransaction(
      final BigInteger nonce,
      final BigInteger gasPrice,
      final BigInteger gasLimit,
      final String to,
      final String data,
      final TesseraBase64String privateFrom,
      final Base64String privacyGroupId,
      final Restriction restriction) {

    return new RawTesseraPrivateTransaction(
        LegacyTransaction.createTransaction(nonce, gasPrice, gasLimit, to, data),
        privateFrom,
        null,
        privacyGroupId,
        restriction);
  }

  public static RawTesseraPrivateTransaction createTransaction(
      final long chainId,
      final BigInteger nonce,
      final BigInteger maxPriorityFeePerGas,
      final BigInteger maxFeePerGas,
      final BigInteger gasLimit,
      final String to,
      final String data,
      final TesseraBase64String privateFrom,
      final List<TesseraBase64String> privateFor,
      final Restriction restriction) {
    return new RawTesseraPrivateTransaction(
        Transaction1559.createTransaction(
            chainId,
            nonce,
            gasLimit,
            to,
            BigInteger.ZERO,
            data,
            maxPriorityFeePerGas,
            maxFeePerGas),
        privateFrom,
        privateFor,
        null,
        restriction);
  }

  public static RawTesseraPrivateTransaction createTransaction(
      final long chainId,
      final BigInteger nonce,
      final BigInteger maxPriorityFeePerGas,
      final BigInteger maxFeePerGas,
      final BigInteger gasLimit,
      final String to,
      final String data,
      final TesseraBase64String privateFrom,
      final Base64String privacyGroupId,
      final Restriction restriction) {

    return new RawTesseraPrivateTransaction(
        Transaction1559.createTransaction(
            chainId,
            nonce,
            gasLimit,
            to,
            BigInteger.ZERO,
            data,
            maxPriorityFeePerGas,
            maxFeePerGas),
        privateFrom,
        null,
        privacyGroupId,
        restriction);
  }

  public TesseraBase64String getPrivateFrom() {
    return privateFrom;
  }

  public Optional<List<TesseraBase64String>> getPrivateFor() {
    return Optional.ofNullable(privateFor);
  }

  public Optional<Base64String> getPrivacyGroupId() {
    return Optional.ofNullable(privacyGroupId);
  }

  public Restriction getRestriction() {
    return restriction;
  }
}
