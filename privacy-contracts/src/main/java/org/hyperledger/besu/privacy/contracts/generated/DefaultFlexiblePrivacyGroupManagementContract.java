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
package org.hyperledger.besu.privacy.contracts.generated;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * Auto generated code.
 *
 * <p><strong>Do not modify!</strong>
 *
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the <a
 * href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class DefaultFlexiblePrivacyGroupManagementContract extends Contract {
  public static final String BINARY =
      "608060405234801561001057600080fd5b50611666806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063965a25ef1161005b578063965a25ef146101175780639738968c14610147578063a69df4b514610165578063f83d08ba1461016f57610088565b80630d8e6e2c1461008d5780631f52a8ee146100ab5780635aa68ac0146100db57806378b90337146100f9575b600080fd5b610095610179565b6040516100a29190610c10565b60405180910390f35b6100c560048036038101906100c09190610d85565b610183565b6040516100d29190610de9565b60405180910390f35b6100e3610249565b6040516100f09190610f4e565b60405180910390f35b610101610322565b60405161010e9190610de9565b60405180910390f35b610131600480360381019061012c9190611056565b610338565b60405161013e9190610de9565b60405180910390f35b61014f6104b0565b60405161015c9190610de9565b60405180910390f35b61016d610507565b005b6101776105cc565b005b6000600154905090565b60008060149054906101000a900460ff1661019d57600080fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161461022b576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610222906110fc565b60405180910390fd5b60006102368361068f565b9050610240610862565b80915050919050565b60606002805480602002602001604051908101604052809291908181526020016000905b8282101561031957838290600052602060002001805461028c9061114b565b80601f01602080910402602001604051908101604052809291908181526020018280546102b89061114b565b80156103055780601f106102da57610100808354040283529160200191610305565b820191906000526020600020905b8154815290600101906020018083116102e857829003601f168201915b50505050508152602001906001019061026d565b50505050905090565b60008060149054906101000a900460ff16905090565b60008060149054906101000a900460ff161561035357600080fd5b600073ffffffffffffffffffffffffffffffffffffffff1660008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156103e957326000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff1614610477576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161046e906110fc565b60405180910390fd5b6000610482836108a3565b90506001600060146101000a81548160ff0219169083151502179055506104a7610862565b80915050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff1614905090565b600060149054906101000a900460ff161561052157600080fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16146105af576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105a6906110fc565b60405180910390fd5b6001600060146101000a81548160ff021916908315150217905550565b600060149054906101000a900460ff166105e557600080fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff1614610673576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161066a906110fc565b60405180910390fd5b60008060146101000a81548160ff021916908315150217905550565b6000806003836040516106a291906111b9565b90815260200160405180910390205490506000811180156106c857506002805490508111155b156108575760028054905081146107f9576000600260016002805490506106ef9190611209565b81548110610700576106ff61123d565b5b9060005260206000200180546107159061114b565b80601f01602080910402602001604051908101604052809291908181526020018280546107419061114b565b801561078e5780601f106107635761010080835404028352916020019161078e565b820191906000526020600020905b81548152906001019060200180831161077157829003601f168201915b505050505090508060026001846107a59190611209565b815481106107b6576107b561123d565b5b9060005260206000200190805190602001906107d3929190610b14565b50816003826040516107e591906111b9565b908152602001604051809103902081905550505b600280548061080b5761080a61126c565b5b6001900381819060005260206000200160006108279190610b9a565b9055600060038460405161083b91906111b9565b908152602001604051809103902081905550600191505061085d565b60009150505b919050565b60014361086f9190611209565b4041600260405160200161088593929190611426565b60405160208183030381529060405280519060200120600181905550565b6000806001905060005b8351811015610a40576108d98482815181106108cc576108cb61123d565b5b6020026020010151610a4a565b15610944577f1673b13ca99fc5f5d54f8ebc163339b3c03f5f661cec3f5dfe506fdbd2602de660008583815181106109145761091361123d565b5b602002602001015160405161092a9291906114fa565b60405180910390a181801561093d575060005b9150610a2d565b600061096985838151811061095c5761095b61123d565b5b6020026020010151610a75565b90506000816109ad576040518060400160405280601b81526020017f4163636f756e7420697320616c72656164792061204d656d62657200000000008152506109c7565b604051806060016040528060218152602001611610602191395b90507f1673b13ca99fc5f5d54f8ebc163339b3c03f5f661cec3f5dfe506fdbd2602de6828785815181106109fe576109fd61123d565b5b602002602001015183604051610a1693929190611581565b60405180910390a1838015610a285750815b935050505b8080610a38906115c6565b9150506108ad565b5080915050919050565b600080600383604051610a5d91906111b9565b90815260200160405180910390205414159050919050565b600080600383604051610a8891906111b9565b9081526020016040518091039020541415610b0a57600282908060018154018082558091505060019003906000526020600020016000909190919091509080519060200190610ad8929190610b14565b50600280549050600383604051610aef91906111b9565b90815260200160405180910390208190555060019050610b0f565b600090505b919050565b828054610b209061114b565b90600052602060002090601f016020900481019282610b425760008555610b89565b82601f10610b5b57805160ff1916838001178555610b89565b82800160010185558215610b89579182015b82811115610b88578251825591602001919060010190610b6d565b5b509050610b969190610bda565b5090565b508054610ba69061114b565b6000825580601f10610bb85750610bd7565b601f016020900490600052602060002090810190610bd69190610bda565b5b50565b5b80821115610bf3576000816000905550600101610bdb565b5090565b6000819050919050565b610c0a81610bf7565b82525050565b6000602082019050610c256000830184610c01565b92915050565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610c9282610c49565b810181811067ffffffffffffffff82111715610cb157610cb0610c5a565b5b80604052505050565b6000610cc4610c2b565b9050610cd08282610c89565b919050565b600067ffffffffffffffff821115610cf057610cef610c5a565b5b610cf982610c49565b9050602081019050919050565b82818337600083830152505050565b6000610d28610d2384610cd5565b610cba565b905082815260208101848484011115610d4457610d43610c44565b5b610d4f848285610d06565b509392505050565b600082601f830112610d6c57610d6b610c3f565b5b8135610d7c848260208601610d15565b91505092915050565b600060208284031215610d9b57610d9a610c35565b5b600082013567ffffffffffffffff811115610db957610db8610c3a565b5b610dc584828501610d57565b91505092915050565b60008115159050919050565b610de381610dce565b82525050565b6000602082019050610dfe6000830184610dda565b92915050565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610e6a578082015181840152602081019050610e4f565b83811115610e79576000848401525b50505050565b6000610e8a82610e30565b610e948185610e3b565b9350610ea4818560208601610e4c565b610ead81610c49565b840191505092915050565b6000610ec48383610e7f565b905092915050565b6000602082019050919050565b6000610ee482610e04565b610eee8185610e0f565b935083602082028501610f0085610e20565b8060005b85811015610f3c5784840389528151610f1d8582610eb8565b9450610f2883610ecc565b925060208a01995050600181019050610f04565b50829750879550505050505092915050565b60006020820190508181036000830152610f688184610ed9565b905092915050565b600067ffffffffffffffff821115610f8b57610f8a610c5a565b5b602082029050602081019050919050565b600080fd5b6000610fb4610faf84610f70565b610cba565b90508083825260208201905060208402830185811115610fd757610fd6610f9c565b5b835b8181101561101e57803567ffffffffffffffff811115610ffc57610ffb610c3f565b5b8086016110098982610d57565b85526020850194505050602081019050610fd9565b5050509392505050565b600082601f83011261103d5761103c610c3f565b5b813561104d848260208601610fa1565b91505092915050565b60006020828403121561106c5761106b610c35565b5b600082013567ffffffffffffffff81111561108a57611089610c3a565b5b61109684828501611028565b91505092915050565b600082825260208201905092915050565b7f4f726967696e206e6f7420746865206f776e65722e0000000000000000000000600082015250565b60006110e660158361109f565b91506110f1826110b0565b602082019050919050565b60006020820190508181036000830152611115816110d9565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061116357607f821691505b602082108114156111775761117661111c565b5b50919050565b600081905092915050565b600061119382610e30565b61119d818561117d565b93506111ad818560208601610e4c565b80840191505092915050565b60006111c58284611188565b915081905092915050565b6000819050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611214826111d0565b915061121f836111d0565b925082821015611232576112316111da565b5b828203905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603160045260246000fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006112c68261129b565b9050919050565b6112d6816112bb565b82525050565b600081549050919050565b60008190508160005260206000209050919050565b60008190508160005260206000209050919050565b6000815461131e8161114b565b6113288186610e3b565b94506001821660008114611343576001811461135557611388565b60ff1983168652602086019350611388565b61135e856112fc565b60005b8381101561138057815481890152600182019150602081019050611361565b808801955050505b50505092915050565b600061139d8383611311565b905092915050565b6000600182019050919050565b60006113bd826112dc565b6113c78185610e0f565b9350836020820285016113d9856112e7565b8060005b85811015611414578484038952816113f58582611391565b9450611400836113a5565b925060208a019950506001810190506113dd565b50829750879550505050505092915050565b600060608201905061143b6000830186610c01565b61144860208301856112cd565b818103604083015261145a81846113b2565b9050949350505050565b600082825260208201905092915050565b600061148082610e30565b61148a8185611464565b935061149a818560208601610e4c565b6114a381610c49565b840191505092915050565b7f4163636f756e7420697320616c72656164792061204d656d6265720000000000600082015250565b60006114e4601b8361109f565b91506114ef826114ae565b602082019050919050565b600060608201905061150f6000830185610dda565b81810360208301526115218184611475565b90508181036040830152611534816114d7565b90509392505050565b600081519050919050565b60006115538261153d565b61155d818561109f565b935061156d818560208601610e4c565b61157681610c49565b840191505092915050565b60006060820190506115966000830186610dda565b81810360208301526115a88185611475565b905081810360408301526115bc8184611548565b9050949350505050565b60006115d1826111d0565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415611604576116036111da565b5b60018201905091905056fe4d656d626572206163636f756e74206164646564207375636365737366756c6c79a2646970667358221220c9bfac9eb8c9a8032ee8c9c04a1ed4f7b6ca0326f454b24558c850f1e18cefa264736f6c634300080c0033";

  public static final String FUNC_ADDPARTICIPANTS = "addParticipants";

  public static final String FUNC_CANEXECUTE = "canExecute";

  public static final String FUNC_CANUPGRADE = "canUpgrade";

  public static final String FUNC_GETPARTICIPANTS = "getParticipants";

  public static final String FUNC_GETVERSION = "getVersion";

  public static final String FUNC_LOCK = "lock";

  public static final String FUNC_REMOVEPARTICIPANT = "removeParticipant";

  public static final String FUNC_UNLOCK = "unlock";

  public static final Event PARTICIPANTADDED_EVENT =
      new Event(
          "ParticipantAdded",
          Arrays.<TypeReference<?>>asList(
              new TypeReference<Bool>() {},
              new TypeReference<DynamicBytes>() {},
              new TypeReference<Utf8String>() {}));
  ;

  @Deprecated
  protected DefaultFlexiblePrivacyGroupManagementContract(
      String contractAddress,
      Web3j web3j,
      Credentials credentials,
      BigInteger gasPrice,
      BigInteger gasLimit) {
    super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
  }

  protected DefaultFlexiblePrivacyGroupManagementContract(
      String contractAddress,
      Web3j web3j,
      Credentials credentials,
      ContractGasProvider contractGasProvider) {
    super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
  }

  @Deprecated
  protected DefaultFlexiblePrivacyGroupManagementContract(
      String contractAddress,
      Web3j web3j,
      TransactionManager transactionManager,
      BigInteger gasPrice,
      BigInteger gasLimit) {
    super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
  }

  protected DefaultFlexiblePrivacyGroupManagementContract(
      String contractAddress,
      Web3j web3j,
      TransactionManager transactionManager,
      ContractGasProvider contractGasProvider) {
    super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
  }

  public List<ParticipantAddedEventResponse> getParticipantAddedEvents(
      TransactionReceipt transactionReceipt) {
    List<Contract.EventValuesWithLog> valueList =
        extractEventParametersWithLog(PARTICIPANTADDED_EVENT, transactionReceipt);
    ArrayList<ParticipantAddedEventResponse> responses =
        new ArrayList<ParticipantAddedEventResponse>(valueList.size());
    for (Contract.EventValuesWithLog eventValues : valueList) {
      ParticipantAddedEventResponse typedResponse = new ParticipantAddedEventResponse();
      typedResponse.log = eventValues.getLog();
      typedResponse.success = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
      typedResponse.publicEnclaveKey = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
      typedResponse.message = (String) eventValues.getNonIndexedValues().get(2).getValue();
      responses.add(typedResponse);
    }
    return responses;
  }

  public Flowable<ParticipantAddedEventResponse> participantAddedEventFlowable(EthFilter filter) {
    return web3j
        .ethLogFlowable(filter)
        .map(
            new Function<Log, ParticipantAddedEventResponse>() {
              @Override
              public ParticipantAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues =
                    extractEventParametersWithLog(PARTICIPANTADDED_EVENT, log);
                ParticipantAddedEventResponse typedResponse = new ParticipantAddedEventResponse();
                typedResponse.log = log;
                typedResponse.success =
                    (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.publicEnclaveKey =
                    (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.message =
                    (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
              }
            });
  }

  public Flowable<ParticipantAddedEventResponse> participantAddedEventFlowable(
      DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
    EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
    filter.addSingleTopic(EventEncoder.encode(PARTICIPANTADDED_EVENT));
    return participantAddedEventFlowable(filter);
  }

  public RemoteFunctionCall<TransactionReceipt> addParticipants(List<byte[]> _publicEnclaveKeys) {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_ADDPARTICIPANTS,
            Arrays.<Type>asList(
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                    org.web3j.abi.datatypes.DynamicBytes.class,
                    org.web3j.abi.Utils.typeMap(
                        _publicEnclaveKeys, org.web3j.abi.datatypes.DynamicBytes.class))),
            Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<Boolean> canExecute() {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_CANEXECUTE,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    return executeRemoteCallSingleValueReturn(function, Boolean.class);
  }

  public RemoteFunctionCall<Boolean> canUpgrade() {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_CANUPGRADE,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    return executeRemoteCallSingleValueReturn(function, Boolean.class);
  }

  public RemoteFunctionCall<List> getParticipants() {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_GETPARTICIPANTS,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<DynamicBytes>>() {}));
    return new RemoteFunctionCall<List>(
        function,
        new Callable<List>() {
          @Override
          @SuppressWarnings("unchecked")
          public List call() throws Exception {
            List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
            return convertToNative(result);
          }
        });
  }

  public RemoteFunctionCall<byte[]> getVersion() {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_GETVERSION,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    return executeRemoteCallSingleValueReturn(function, byte[].class);
  }

  public RemoteFunctionCall<TransactionReceipt> lock() {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_LOCK, Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<TransactionReceipt> removeParticipant(byte[] _participant) {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_REMOVEPARTICIPANT,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(_participant)),
            Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  public RemoteFunctionCall<TransactionReceipt> unlock() {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_UNLOCK, Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
  }

  @Deprecated
  public static DefaultFlexiblePrivacyGroupManagementContract load(
      String contractAddress,
      Web3j web3j,
      Credentials credentials,
      BigInteger gasPrice,
      BigInteger gasLimit) {
    return new DefaultFlexiblePrivacyGroupManagementContract(
        contractAddress, web3j, credentials, gasPrice, gasLimit);
  }

  @Deprecated
  public static DefaultFlexiblePrivacyGroupManagementContract load(
      String contractAddress,
      Web3j web3j,
      TransactionManager transactionManager,
      BigInteger gasPrice,
      BigInteger gasLimit) {
    return new DefaultFlexiblePrivacyGroupManagementContract(
        contractAddress, web3j, transactionManager, gasPrice, gasLimit);
  }

  public static DefaultFlexiblePrivacyGroupManagementContract load(
      String contractAddress,
      Web3j web3j,
      Credentials credentials,
      ContractGasProvider contractGasProvider) {
    return new DefaultFlexiblePrivacyGroupManagementContract(
        contractAddress, web3j, credentials, contractGasProvider);
  }

  public static DefaultFlexiblePrivacyGroupManagementContract load(
      String contractAddress,
      Web3j web3j,
      TransactionManager transactionManager,
      ContractGasProvider contractGasProvider) {
    return new DefaultFlexiblePrivacyGroupManagementContract(
        contractAddress, web3j, transactionManager, contractGasProvider);
  }

  public static RemoteCall<DefaultFlexiblePrivacyGroupManagementContract> deploy(
      Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
    return deployRemoteCall(
        DefaultFlexiblePrivacyGroupManagementContract.class,
        web3j,
        credentials,
        contractGasProvider,
        BINARY,
        "");
  }

  @Deprecated
  public static RemoteCall<DefaultFlexiblePrivacyGroupManagementContract> deploy(
      Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
    return deployRemoteCall(
        DefaultFlexiblePrivacyGroupManagementContract.class,
        web3j,
        credentials,
        gasPrice,
        gasLimit,
        BINARY,
        "");
  }

  public static RemoteCall<DefaultFlexiblePrivacyGroupManagementContract> deploy(
      Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
    return deployRemoteCall(
        DefaultFlexiblePrivacyGroupManagementContract.class,
        web3j,
        transactionManager,
        contractGasProvider,
        BINARY,
        "");
  }

  @Deprecated
  public static RemoteCall<DefaultFlexiblePrivacyGroupManagementContract> deploy(
      Web3j web3j,
      TransactionManager transactionManager,
      BigInteger gasPrice,
      BigInteger gasLimit) {
    return deployRemoteCall(
        DefaultFlexiblePrivacyGroupManagementContract.class,
        web3j,
        transactionManager,
        gasPrice,
        gasLimit,
        BINARY,
        "");
  }

  public static class ParticipantAddedEventResponse extends BaseEventResponse {
    public Boolean success;

    public byte[] publicEnclaveKey;

    public String message;
  }
}
