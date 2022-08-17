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
      "608060405234801561001057600080fd5b5061166b806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063965a25ef1161005b578063965a25ef146101175780639738968c14610147578063a69df4b514610165578063f83d08ba1461016f57610088565b80630d8e6e2c1461008d5780631f52a8ee146100ab5780635aa68ac0146100db57806378b90337146100f9575b600080fd5b610095610179565b6040516100a29190610c15565b60405180910390f35b6100c560048036038101906100c09190610d8a565b610183565b6040516100d29190610dee565b60405180910390f35b6100e361024a565b6040516100f09190610f53565b60405180910390f35b610101610323565b60405161010e9190610dee565b60405180910390f35b610131600480360381019061012c919061105b565b610339565b60405161013e9190610dee565b60405180910390f35b61014f6104b2565b60405161015c9190610dee565b60405180910390f35b61016d610509565b005b6101776105ce565b005b6000600154905090565b60008060149054906101000a900460ff1661019d57600080fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161461022b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161022290611101565b60405180910390fd5b600061023683610691565b9050610240610864565b5080915050919050565b60606002805480602002602001604051908101604052809291908181526020016000905b8282101561031a57838290600052602060002001805461028d90611150565b80601f01602080910402602001604051908101604052809291908181526020018280546102b990611150565b80156103065780601f106102db57610100808354040283529160200191610306565b820191906000526020600020905b8154815290600101906020018083116102e957829003601f168201915b50505050508152602001906001019061026e565b50505050905090565b60008060149054906101000a900460ff16905090565b60008060149054906101000a900460ff161561035457600080fd5b600073ffffffffffffffffffffffffffffffffffffffff1660008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156103ea57326000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff1614610478576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161046f90611101565b60405180910390fd5b6000610483836108a8565b90506001600060146101000a81548160ff0219169083151502179055506104a8610864565b5080915050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff1614905090565b600060149054906101000a900460ff161561052357600080fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16146105b1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105a890611101565b60405180910390fd5b6001600060146101000a81548160ff021916908315150217905550565b600060149054906101000a900460ff166105e757600080fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff1614610675576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161066c90611101565b60405180910390fd5b60008060146101000a81548160ff021916908315150217905550565b6000806003836040516106a491906111be565b90815260200160405180910390205490506000811180156106ca57506002805490508111155b156108595760028054905081146107fb576000600260016002805490506106f1919061120e565b8154811061070257610701611242565b5b90600052602060002001805461071790611150565b80601f016020809104026020016040519081016040528092919081815260200182805461074390611150565b80156107905780601f1061076557610100808354040283529160200191610790565b820191906000526020600020905b81548152906001019060200180831161077357829003601f168201915b505050505090508060026001846107a7919061120e565b815481106107b8576107b7611242565b5b9060005260206000200190805190602001906107d5929190610b19565b50816003826040516107e791906111be565b908152602001604051809103902081905550505b600280548061080d5761080c611271565b5b6001900381819060005260206000200160006108299190610b9f565b9055600060038460405161083d91906111be565b908152602001604051809103902081905550600191505061085f565b60009150505b919050565b6000600143610873919061120e565b404160026040516020016108899392919061142b565b6040516020818303038152906040528051906020012060018190555090565b6000806001905060005b8351811015610a45576108de8482815181106108d1576108d0611242565b5b6020026020010151610a4f565b15610949577f1673b13ca99fc5f5d54f8ebc163339b3c03f5f661cec3f5dfe506fdbd2602de6600085838151811061091957610918611242565b5b602002602001015160405161092f9291906114ff565b60405180910390a1818015610942575060005b9150610a32565b600061096e85838151811061096157610960611242565b5b6020026020010151610a7a565b90506000816109b2576040518060400160405280601b81526020017f4163636f756e7420697320616c72656164792061204d656d62657200000000008152506109cc565b604051806060016040528060218152602001611615602191395b90507f1673b13ca99fc5f5d54f8ebc163339b3c03f5f661cec3f5dfe506fdbd2602de682878581518110610a0357610a02611242565b5b602002602001015183604051610a1b93929190611586565b60405180910390a1838015610a2d5750815b935050505b8080610a3d906115cb565b9150506108b2565b5080915050919050565b600080600383604051610a6291906111be565b90815260200160405180910390205414159050919050565b600080600383604051610a8d91906111be565b9081526020016040518091039020541415610b0f57600282908060018154018082558091505060019003906000526020600020016000909190919091509080519060200190610add929190610b19565b50600280549050600383604051610af491906111be565b90815260200160405180910390208190555060019050610b14565b600090505b919050565b828054610b2590611150565b90600052602060002090601f016020900481019282610b475760008555610b8e565b82601f10610b6057805160ff1916838001178555610b8e565b82800160010185558215610b8e579182015b82811115610b8d578251825591602001919060010190610b72565b5b509050610b9b9190610bdf565b5090565b508054610bab90611150565b6000825580601f10610bbd5750610bdc565b601f016020900490600052602060002090810190610bdb9190610bdf565b5b50565b5b80821115610bf8576000816000905550600101610be0565b5090565b6000819050919050565b610c0f81610bfc565b82525050565b6000602082019050610c2a6000830184610c06565b92915050565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610c9782610c4e565b810181811067ffffffffffffffff82111715610cb657610cb5610c5f565b5b80604052505050565b6000610cc9610c30565b9050610cd58282610c8e565b919050565b600067ffffffffffffffff821115610cf557610cf4610c5f565b5b610cfe82610c4e565b9050602081019050919050565b82818337600083830152505050565b6000610d2d610d2884610cda565b610cbf565b905082815260208101848484011115610d4957610d48610c49565b5b610d54848285610d0b565b509392505050565b600082601f830112610d7157610d70610c44565b5b8135610d81848260208601610d1a565b91505092915050565b600060208284031215610da057610d9f610c3a565b5b600082013567ffffffffffffffff811115610dbe57610dbd610c3f565b5b610dca84828501610d5c565b91505092915050565b60008115159050919050565b610de881610dd3565b82525050565b6000602082019050610e036000830184610ddf565b92915050565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610e6f578082015181840152602081019050610e54565b83811115610e7e576000848401525b50505050565b6000610e8f82610e35565b610e998185610e40565b9350610ea9818560208601610e51565b610eb281610c4e565b840191505092915050565b6000610ec98383610e84565b905092915050565b6000602082019050919050565b6000610ee982610e09565b610ef38185610e14565b935083602082028501610f0585610e25565b8060005b85811015610f415784840389528151610f228582610ebd565b9450610f2d83610ed1565b925060208a01995050600181019050610f09565b50829750879550505050505092915050565b60006020820190508181036000830152610f6d8184610ede565b905092915050565b600067ffffffffffffffff821115610f9057610f8f610c5f565b5b602082029050602081019050919050565b600080fd5b6000610fb9610fb484610f75565b610cbf565b90508083825260208201905060208402830185811115610fdc57610fdb610fa1565b5b835b8181101561102357803567ffffffffffffffff81111561100157611000610c44565b5b80860161100e8982610d5c565b85526020850194505050602081019050610fde565b5050509392505050565b600082601f83011261104257611041610c44565b5b8135611052848260208601610fa6565b91505092915050565b60006020828403121561107157611070610c3a565b5b600082013567ffffffffffffffff81111561108f5761108e610c3f565b5b61109b8482850161102d565b91505092915050565b600082825260208201905092915050565b7f4f726967696e206e6f7420746865206f776e65722e0000000000000000000000600082015250565b60006110eb6015836110a4565b91506110f6826110b5565b602082019050919050565b6000602082019050818103600083015261111a816110de565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061116857607f821691505b6020821081141561117c5761117b611121565b5b50919050565b600081905092915050565b600061119882610e35565b6111a28185611182565b93506111b2818560208601610e51565b80840191505092915050565b60006111ca828461118d565b915081905092915050565b6000819050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611219826111d5565b9150611224836111d5565b925082821015611237576112366111df565b5b828203905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603160045260246000fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006112cb826112a0565b9050919050565b6112db816112c0565b82525050565b600081549050919050565b60008190508160005260206000209050919050565b60008190508160005260206000209050919050565b6000815461132381611150565b61132d8186610e40565b94506001821660008114611348576001811461135a5761138d565b60ff198316865260208601935061138d565b61136385611301565b60005b8381101561138557815481890152600182019150602081019050611366565b808801955050505b50505092915050565b60006113a28383611316565b905092915050565b6000600182019050919050565b60006113c2826112e1565b6113cc8185610e14565b9350836020820285016113de856112ec565b8060005b85811015611419578484038952816113fa8582611396565b9450611405836113aa565b925060208a019950506001810190506113e2565b50829750879550505050505092915050565b60006060820190506114406000830186610c06565b61144d60208301856112d2565b818103604083015261145f81846113b7565b9050949350505050565b600082825260208201905092915050565b600061148582610e35565b61148f8185611469565b935061149f818560208601610e51565b6114a881610c4e565b840191505092915050565b7f4163636f756e7420697320616c72656164792061204d656d6265720000000000600082015250565b60006114e9601b836110a4565b91506114f4826114b3565b602082019050919050565b60006060820190506115146000830185610ddf565b8181036020830152611526818461147a565b90508181036040830152611539816114dc565b90509392505050565b600081519050919050565b600061155882611542565b61156281856110a4565b9350611572818560208601610e51565b61157b81610c4e565b840191505092915050565b600060608201905061159b6000830186610ddf565b81810360208301526115ad818561147a565b905081810360408301526115c1818461154d565b9050949350505050565b60006115d6826111d5565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415611609576116086111df565b5b60018201905091905056fe4d656d626572206163636f756e74206164646564207375636365737366756c6c79a26469706673582212207351f098afc65d666780043ebc448a988b12410e057b511aeda8d6dd9dacb93064736f6c634300080c0033";

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

  public RemoteFunctionCall<TransactionReceipt> canUpgrade() {
    final org.web3j.abi.datatypes.Function function =
        new org.web3j.abi.datatypes.Function(
            FUNC_CANUPGRADE, Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
    return executeRemoteCallTransaction(function);
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
