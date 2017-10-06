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
import org.web3j.abi.datatypes.Utf8String;
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
public final class RewardId extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405161052b38038061052b8339810160405280805190910190505b60008054600160a060020a03191633600160a060020a03161790556001818051610059929160200190610061565b505b50610101565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100a257805160ff19168380011785556100cf565b828001600101855582156100cf579182015b828111156100cf5782518255916020019190600101906100b4565b5b506100dc9291506100e0565b5090565b6100fe91905b808211156100dc57600081556001016100e6565b5090565b90565b61041b806101106000396000f300606060405263ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166307d1e42f811461005357806317d7de7c146100a657806341c0e1b514610141575b600080fd5b341561005e57600080fd5b6100a460046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061016695505050505050565b005b34156100b157600080fd5b6100b961019c565b604051600160a060020a038316815260406020820181815290820183818151815260200191508051906020019080838360005b838110156101055780820151818401525b6020016100ec565b50505050905090810190601f1680156101325780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561014c57600080fd5b61015461030d565b60405190815260200160405180910390f35b600054600160a060020a03908116903316811461018257600080fd5b600182805161019592916020019061033d565b505b5b5050565b60006101a66103bc565b60005460018054600160a060020a039092169350906002600019828416156101000201909116046020601f8201819004810201604051908101604052809291908181526020018280546001816001161561010002031660029004801561024d5780601f106102225761010080835404028352916020019161024d565b820191906000526020600020905b81548152906001019060200180831161023057829003601f168201915b5050505050905033600160a060020a03167f2cee111a658042bb7efb6ce8d8fb7c0a9a76d610ce29268caf02e7e9ff1f6bf48383604051600160a060020a038316815260406020820181815290820183818151815260200191508051906020019080838360005b838110156102cd5780820151818401525b6020016102b4565b50505050905090810190601f1680156102fa5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a25b9091565b60008054600160a060020a03908116903316811461032a57600080fd5b600054600160a060020a0316ff5b5b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061037e57805160ff19168380011785556103ab565b828001600101855582156103ab579182015b828111156103ab578251825591602001919060010190610390565b5b506103389291506103ce565b5090565b60206040519081016040526000815290565b6103ec91905b8082111561033857600081556001016103d4565b5090565b905600a165627a7a7230582056ac9d8b3acff5089ae4bac13c69e250422d94b7b91a60e6f3889d23855ace160029";

    private RewardId(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public RewardId(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<OutputIdEventResponse> getOutputIdEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OutputId", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutputIdEventResponse> responses = new ArrayList<OutputIdEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutputIdEventResponse typedResponse = new OutputIdEventResponse();
            typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.owner_ = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.nameId_ = (Utf8String) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutputIdEventResponse> outputIdEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OutputId", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutputIdEventResponse>() {
            @Override
            public OutputIdEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutputIdEventResponse typedResponse = new OutputIdEventResponse();
                typedResponse.sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.owner_ = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.nameId_ = (Utf8String) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> setNewName(Utf8String _nameId) {
        Function function = new Function("setNewName", Arrays.<Type>asList(_nameId), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> getName() {
        Function function = new Function("getName", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<RewardId> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Utf8String _nameId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nameId));
        return deployAsync(RewardId.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<RewardId> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Utf8String _nameId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_nameId));
        return deployAsync(RewardId.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RewardId load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardId(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RewardId load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardId(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class OutputIdEventResponse {
        public Address sender;

        public Address owner_;

        public Utf8String nameId_;
    }
}
