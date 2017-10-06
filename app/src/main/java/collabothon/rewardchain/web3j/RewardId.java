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
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516105153803806105158339810160405280805160008054600160a060020a03191633600160a060020a03161790559190910190506001818051610059929160200190610060565b50506100fb565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100a157805160ff19168380011785556100ce565b828001600101855582156100ce579182015b828111156100ce5782518255916020019190600101906100b3565b506100da9291506100de565b5090565b6100f891905b808211156100da57600081556001016100e4565b90565b61040b8061010a6000396000f300606060405263ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166307d1e42f811461005257806317d7de7c146100a557806341c0e1b51461013f57600080fd5b341561005d57600080fd5b6100a360046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061016495505050505050565b005b34156100b057600080fd5b6100b8610198565b604051600160a060020a038316815260406020820181815290820183818151815260200191508051906020019080838360005b838110156101035780820151838201526020016100eb565b50505050905090810190601f1680156101305780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561014a57600080fd5b610152610307565b60405190815260200160405180910390f35b600054600160a060020a03908116903316811461018057600080fd5b6001828051610193929160200190610332565b505050565b60006101a26103b0565b60005460018054600160a060020a039092169350906002600019828416156101000201909116046020601f820181900481020160405190810160405280929190818152602001828054600181600116156101000203166002900480156102495780601f1061021e57610100808354040283529160200191610249565b820191906000526020600020905b81548152906001019060200180831161022c57829003601f168201915b5050505050905033600160a060020a03167f2cee111a658042bb7efb6ce8d8fb7c0a9a76d610ce29268caf02e7e9ff1f6bf48383604051600160a060020a038316815260406020820181815290820183818151815260200191508051906020019080838360005b838110156102c85780820151838201526020016102b0565b50505050905090810190601f1680156102f55780820380516001836020036101000a031916815260200191505b50935050505060405180910390a29091565b60008054600160a060020a03908116903316811461032457600080fd5b600054600160a060020a0316ff5b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061037357805160ff19168380011785556103a0565b828001600101855582156103a0579182015b828111156103a0578251825591602001919060010190610385565b506103ac9291506103c2565b5090565b60206040519081016040526000815290565b6103dc91905b808211156103ac57600081556001016103c8565b905600a165627a7a723058202e15f88fb2ed5adc3c779e70560710fdd7a0604f9e67e899c732f52e132577c20029";

    private RewardId(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private RewardId(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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
