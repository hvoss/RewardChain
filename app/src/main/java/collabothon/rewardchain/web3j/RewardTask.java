package collabothon.rewardchain.web3j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.3.1.
 */
public final class RewardTask extends Contract {
    private static final String BINARY = "6060604052604051602080610cad8339810160405280805160008054600160a060020a033316600160a060020a03199091161790556003805461ffff191690556004555050610c5a806100536000396000f300606060405236156100a15763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b581146100a35780634bf54a44146100c85780635cd76a57146101085780636a9116ee1461011057806371f02f061461015157806399f5932814610164578063a29a055214610183578063ae8421e1146101aa578063ce438428146101bd578063fa1f3772146101d3575b005b34156100ae57600080fd5b6100b66101f2565b60405190815260200160405180910390f35b34156100d357600080fd5b6100db61021d565b6040519283526020830191909152600160a060020a03166040808301919091526060909101905180910390f35b6100a16103b8565b341561011b57600080fd5b61012f600160a060020a0360043516610608565b604051600160a060020a03909216825260208201526040908101905180910390f35b341561015c57600080fd5b6100b66106a9565b341561016f57600080fd5b6100a1600160a060020a03600435166106af565b341561018e57600080fd5b610196610778565b604051901515815260200160405180910390f35b34156101b557600080fd5b610196610781565b34156101c857600080fd5b6100a160043561078f565b34156101de57600080fd5b6100a1600160a060020a036004351661096c565b60008054600160a060020a03908116903316811461020f57600080fd5b600054600160a060020a0316ff5b60008054819081908190600160a060020a03908116903316811461024057600080fd5b60035460ff161515610320576002549450600091505b60025482101561031b5781935060028281548110151561027257fe5b906000526020600020900160009054906101000a9004600160a060020a0316925033600160a060020a03167f9481d764a461972837b7860e42d6f7ec4110cabe22b4bed2790519db0097f70b86866002868154811015156102cf57fe5b600091825260209091200154600160a060020a03166040519283526020830191909152600160a060020a03166040808301919091526060909101905180910390a2600190910190610256565b6103b1565b600154600554600160a060020a03338116927f5aebb973c8b02262fe320e00f9f37dda54887f5638a84bf19c4493cfdf31531992911690604051600160a060020a03909216602083015260408083019190915260608083526013908301527f5461736b20616c726561647920626f6f6b656400000000000000000000000000608083015260a0909101905180910390a25b5050909192565b600054600160a060020a0390811690331681146103d457600080fd5b60035460ff1680156103ee5750600354610100900460ff16155b156104da576003805461ff001916610100179055600154600554600160a060020a0390911690670de0b6b3a76400000280156108fc0290604051600060405180830381858888f19350505050151561044557600080fd5b600154600554600160a060020a03338116927f236e9a739c86e988804d605eb3d8a310e71493ac46ae7c38e0424b19d7f7840592911690604051600160a060020a0390921660208301526040808301919091526060808352601b908301527f436f6e6669726d656420657865637574696f6e206f66205461736b0000000000608083015260a0909101905180910390a2610605565b60035460ff1680156104f35750600354610100900460ff165b1561057b57600154600160a060020a03338116917fb4f4dfbecbc3138e2c3ba821c6c43c2a920b50dc358227d87301099bc2c1a8889116604051600160a060020a03909116602082015260408082526017818301527f416c726561647920626f6f6b656420616e6420646f6e6500000000000000000060608301526080909101905180910390a25b60035460ff1615156106055733600160a060020a03167fb4f4dfbecbc3138e2c3ba821c6c43c2a920b50dc358227d87301099bc2c1a8886000604051600160a060020a0390911660208201526040808252600e818301527f4e6f742079657420626f6f6b656400000000000000000000000000000000000060608301526080909101905180910390a25b50565b600080548190600160a060020a03908116903316811461062757600080fd5b8392506006600085600160a060020a0316600160a060020a0316815260200190815260200160002060000154915033600160a060020a03167f577514b8d3487fef020876babb6d9132524fd9e879f8cf5d9938ccaaa8e451bb8484604051600160a060020a03909216825260208201526040908101905180910390a250915091565b60045481565b600080548190600160a060020a039081169033168114156106cf57600080fd5b60009250600091505b6002548210156107265783600160a060020a03166002838154811015156106fb57fe5b600091825260209091200154600160a060020a0316141561071b57600192505b6001909101906106d8565b82151561077257600280546001810161073f8382610be4565b506000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0386161790555b50505050565b60035460ff1681565b600354610100900460ff1681565b600054600160a060020a039081169033168114156107ac57600080fd5b60035460ff1615156108f8576004548211610886576003805460ff191660019081179091558054600160a060020a0333811673ffffffffffffffffffffffffffffffffffffffff19909216821792839055600585905590917fe0156c003e97dc9ff5a15b8ad7676ddcde64b12900041dc231c0b253b3650d7b911684604051600160a060020a0390921660208301526040808301919091526060808352600b908301527f5461736b20626f6f6b6564000000000000000000000000000000000000000000608083015260a0909101905180910390a26108f3565b61088f336106af565b33600160a060020a0381166000818152600660205260409081902085905590917f577514b8d3487fef020876babb6d9132524fd9e879f8cf5d9938ccaaa8e451bb91859051600160a060020a03909216825260208201526040908101905180910390a25b610968565b33600160a060020a03167f278ecde9c18a747bcdf82202dd626a399ccf9943d490823f2a9b5fe3d56346b960405160208082526013908201527f5461736b20616c726561647920626f6f6b6564000000000000000000000000006040808301919091526060909101905180910390a25b5050565b600080548190600160a060020a03908116903316811461098b57600080fd5b60035460ff161515610b4e5760009250600091505b6002548210156109ee5783600160a060020a03166002838154811015156109c357fe5b600091825260209091200154600160a060020a031614156109e357600192505b6001909101906109a0565b8215610acc576001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03868116918217808455600092835260066020526040928390205460058190556003805460ff1916909517909455338216937fe0156c003e97dc9ff5a15b8ad7676ddcde64b12900041dc231c0b253b3650d7b9391909216919051600160a060020a0390921660208301526040808301919091526060808352600b908301527f5461736b20626f6f6b6564000000000000000000000000000000000000000000608083015260a0909101905180910390a2610b49565b33600160a060020a03167fb4f4dfbecbc3138e2c3ba821c6c43c2a920b50dc358227d87301099bc2c1a88885604051600160a060020a0390911660208201526040808252601c818301527f4e6f2073756767657374696f6e2066726f6d207468697320557365720000000060608301526080909101905180910390a25b610772565b600154600554600160a060020a03338116927f5aebb973c8b02262fe320e00f9f37dda54887f5638a84bf19c4493cfdf31531992911690604051600160a060020a03909216602083015260408083019190915260608083526013908301527f5461736b20616c726561647920626f6f6b656400000000000000000000000000608083015260a0909101905180910390a250505050565b815481835581811511610c0857600083815260209020610c08918101908301610c0d565b505050565b610c2b91905b80821115610c275760008155600101610c13565b5090565b905600a165627a7a7230582040ebb865b2ee31adb96348ef23ec51da3ff8caadf2a40b265fa17a78709d11f80029";

    private RewardTask(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private RewardTask(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<OutputTaskDataEventResponse> getOutputTaskDataEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputTaskData", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputTaskDataEventResponse> responses = new ArrayList<OutputTaskDataEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputTaskDataEventResponse typedResponse = new OutputTaskDataEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.owner_ = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.offerValue_ = (Uint256) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputTaskDataEventResponse> outputTaskDataEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputTaskData", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputTaskDataEventResponse>() {
            @Override
            public OutputTaskDataEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputTaskDataEventResponse typedResponse = new OutputTaskDataEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.owner_ = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.offerValue_ = (Uint256) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<OutputSuggestionEventResponse> getOutputSuggestionEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputSuggestion", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputSuggestionEventResponse> responses = new ArrayList<OutputSuggestionEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputSuggestionEventResponse typedResponse = new OutputSuggestionEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.suggestionAddress_ = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.suggestionValue_ = (Uint256) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputSuggestionEventResponse> outputSuggestionEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputSuggestion", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputSuggestionEventResponse>() {
            @Override
            public OutputSuggestionEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputSuggestionEventResponse typedResponse = new OutputSuggestionEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.suggestionAddress_ = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.suggestionValue_ = (Uint256) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<OutputSuggestionAddressesEventResponse> getOutputSuggestionAddressesEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputSuggestionAddresses", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputSuggestionAddressesEventResponse> responses = new ArrayList<OutputSuggestionAddressesEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputSuggestionAddressesEventResponse typedResponse = new OutputSuggestionAddressesEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.countAddresses_ = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse.aktCount_ = (Uint256) eventValues.getNonIndexedValues().get(1);
            typedResponse.suggestionAddress_ = (Address) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputSuggestionAddressesEventResponse> outputSuggestionAddressesEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputSuggestionAddresses", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputSuggestionAddressesEventResponse>() {
            @Override
            public OutputSuggestionAddressesEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputSuggestionAddressesEventResponse typedResponse = new OutputSuggestionAddressesEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.countAddresses_ = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse.aktCount_ = (Uint256) eventValues.getNonIndexedValues().get(1);
                typedResponse.suggestionAddress_ = (Address) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<OutputAlreadyBookedAnonymEventResponse> getOutputAlreadyBookedAnonymEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputAlreadyBookedAnonym", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputAlreadyBookedAnonymEventResponse> responses = new ArrayList<OutputAlreadyBookedAnonymEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputAlreadyBookedAnonymEventResponse typedResponse = new OutputAlreadyBookedAnonymEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.messaageBooked_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputAlreadyBookedAnonymEventResponse> outputAlreadyBookedAnonymEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputAlreadyBookedAnonym", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputAlreadyBookedAnonymEventResponse>() {
            @Override
            public OutputAlreadyBookedAnonymEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputAlreadyBookedAnonymEventResponse typedResponse = new OutputAlreadyBookedAnonymEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.messaageBooked_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<OutputAlreadyBookedEventResponse> getOutputAlreadyBookedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputAlreadyBooked", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputAlreadyBookedEventResponse> responses = new ArrayList<OutputAlreadyBookedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputAlreadyBookedEventResponse typedResponse = new OutputAlreadyBookedEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.messaageBooked_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.executer_ = (Address) eventValues.getNonIndexedValues().get(1);
            typedResponse.executionValue_ = (Uint256) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputAlreadyBookedEventResponse> outputAlreadyBookedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputAlreadyBooked", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputAlreadyBookedEventResponse>() {
            @Override
            public OutputAlreadyBookedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputAlreadyBookedEventResponse typedResponse = new OutputAlreadyBookedEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.messaageBooked_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.executer_ = (Address) eventValues.getNonIndexedValues().get(1);
                typedResponse.executionValue_ = (Uint256) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<OutputBookedEventResponse> getOutputBookedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputBooked", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputBookedEventResponse> responses = new ArrayList<OutputBookedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputBookedEventResponse typedResponse = new OutputBookedEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.messaageBooked_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.executer_ = (Address) eventValues.getNonIndexedValues().get(1);
            typedResponse.executionValue_ = (Uint256) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputBookedEventResponse> outputBookedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputBooked", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputBookedEventResponse>() {
            @Override
            public OutputBookedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputBookedEventResponse typedResponse = new OutputBookedEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.messaageBooked_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.executer_ = (Address) eventValues.getNonIndexedValues().get(1);
                typedResponse.executionValue_ = (Uint256) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<OutputErrorEventResponse> getOutputErrorEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputError", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputErrorEventResponse> responses = new ArrayList<OutputErrorEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputErrorEventResponse typedResponse = new OutputErrorEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.messageError_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.wrongAddress_ = (Address) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputErrorEventResponse> outputErrorEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputError", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputErrorEventResponse>() {
            @Override
            public OutputErrorEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputErrorEventResponse typedResponse = new OutputErrorEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.messageError_ = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.wrongAddress_ = (Address) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<OutputExecutionEventResponse> getOutputExecutionEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputExecution", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputExecutionEventResponse> responses = new ArrayList<OutputExecutionEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputExecutionEventResponse typedResponse = new OutputExecutionEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.messageExecution = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse.executer_ = (Address) eventValues.getNonIndexedValues().get(1);
            typedResponse.executionValue_ = (Uint256) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputExecutionEventResponse> outputExecutionEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputExecution", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputExecutionEventResponse>() {
            @Override
            public OutputExecutionEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputExecutionEventResponse typedResponse = new OutputExecutionEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.messageExecution = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse.executer_ = (Address) eventValues.getNonIndexedValues().get(1);
                typedResponse.executionValue_ = (Uint256) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> getSuggestionAddresses() {
        Function function = new Function("getSuggestionAddresses", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> getSuggestions(Address _suggestionAddress) {
        Function function = new Function("getSuggestions", Arrays.<Type>asList(_suggestionAddress), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> offerValue() {
        Function function = new Function("offerValue", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> insertSuggestionAddress(Address _suggestionAddress) {
        Function function = new Function("insertSuggestionAddress", Arrays.<Type>asList(_suggestionAddress), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Bool> booked() {
        Function function = new Function("booked", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Bool> done() {
        Function function = new Function("done", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> insertSuggestion(Uint256 _suggeestionValue) {
        Function function = new Function("insertSuggestion", Arrays.<Type>asList(_suggeestionValue), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> acceptSuggestion(Address _suggestionAddress) {
        Function function = new Function("acceptSuggestion", Arrays.<Type>asList(_suggestionAddress), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<RewardTask> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 offerValue_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(offerValue_));
        return deployAsync(RewardTask.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<RewardTask> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 offerValue_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(offerValue_));
        return deployAsync(RewardTask.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RewardTask load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardTask(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RewardTask load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardTask(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class OutputTaskDataEventResponse {
        public Address sender;

        public Address owner_;

        public Uint256 offerValue_;
    }

    public static class OutputSuggestionEventResponse {
        public Address sender;

        public Address suggestionAddress_;

        public Uint256 suggestionValue_;
    }

    public static class OutputSuggestionAddressesEventResponse {
        public Address sender;

        public Uint256 countAddresses_;

        public Uint256 aktCount_;

        public Address suggestionAddress_;
    }

    public static class OutputAlreadyBookedAnonymEventResponse {
        public Address sender;

        public Utf8String messaageBooked_;
    }

    public static class OutputAlreadyBookedEventResponse {
        public Address sender;

        public Utf8String messaageBooked_;

        public Address executer_;

        public Uint256 executionValue_;
    }

    public static class OutputBookedEventResponse {
        public Address sender;

        public Utf8String messaageBooked_;

        public Address executer_;

        public Uint256 executionValue_;
    }

    public static class OutputErrorEventResponse {
        public Address sender;

        public Utf8String messageError_;

        public Address wrongAddress_;
    }

    public static class OutputExecutionEventResponse {
        public Address sender;

        public Utf8String messageExecution;

        public Address executer_;

        public Uint256 executionValue_;
    }
}
