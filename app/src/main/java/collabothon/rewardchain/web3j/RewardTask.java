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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516020806104dd8339810160405280805160008054600160a060020a033316600160a060020a0319909116179055600255505061048a806100536000396000f300606060405263ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b581146100685780634bf54a441461008d5780636a9116ee146100cd57806399f593281461010e578063ce4384281461012f57600080fd5b341561007357600080fd5b61007b610145565b60405190815260200160405180910390f35b341561009857600080fd5b6100a0610170565b6040519283526020830191909152600160a060020a03166040808301919091526060909101905180910390f35b34156100d857600080fd5b6100ec600160a060020a0360043516610269565b604051600160a060020a03909216825260208201526040908101905180910390f35b341561011957600080fd5b61012d600160a060020a036004351661030a565b005b341561013a57600080fd5b61012d6004356103d2565b60008054600160a060020a03908116903316811461016257600080fd5b600054600160a060020a0316ff5b60008054819081908190600160a060020a03908116903316811461019357600080fd5b6001549450600091505b600154821015610262578193506001828154811015156101b957fe5b906000526020600020900160009054906101000a9004600160a060020a0316925033600160a060020a03167f9481d764a461972837b7860e42d6f7ec4110cabe22b4bed2790519db0097f70b868660018681548110151561021657fe5b600091825260209091200154600160a060020a03166040519283526020830191909152600160a060020a03166040808301919091526060909101905180910390a260019091019061019d565b5050909192565b600080548190600160a060020a03908116903316811461028857600080fd5b8392506003600085600160a060020a0316600160a060020a0316815260200190815260200160002060000154915033600160a060020a03167f577514b8d3487fef020876babb6d9132524fd9e879f8cf5d9938ccaaa8e451bb8484604051600160a060020a03909216825260208201526040908101905180910390a250915091565b600080548190600160a060020a0390811690331681141561032a57600080fd5b60009250600091505b6001548210156103815783600160a060020a031660018381548110151561035657fe5b600091825260209091200154600160a060020a0316141561037657600192505b600190910190610333565b8215156103cc57600180548082016103998382610414565b506000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0386161790555b50505050565b600054600160a060020a039081169033168114156103ef57600080fd5b6103f83361030a565b50600160a060020a033316600090815260036020526040902055565b8154818355818115116104385760008381526020902061043891810190830161043d565b505050565b61045b91905b808211156104575760008155600101610443565b5090565b905600a165627a7a723058209bb65614c302fc9bea3e2e9d0c985a4f0b73b3943fb00d6fdc0b0834169cd8a70029";

    private RewardTask(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private RewardTask(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public Future<TransactionReceipt> insertSuggestionAddress(Address _suggestionAddress) {
        Function function = new Function("insertSuggestionAddress", Arrays.<Type>asList(_suggestionAddress), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> insertSuggestion(Uint256 _suggeestionValue) {
        Function function = new Function("insertSuggestion", Arrays.<Type>asList(_suggeestionValue), Collections.<TypeReference<?>>emptyList());
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
}
