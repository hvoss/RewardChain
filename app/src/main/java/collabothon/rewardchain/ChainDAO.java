package collabothon.rewardchain;

import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.CipherException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.parity.ParityFactory;
import org.web3j.protocol.parity.methods.response.PersonalUnlockAccount;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import collabothon.rewardchain.web3j.RewardId;

/**
 * Created by henrik on 05.10.17.
 */

public class ChainDAO {

    private static String serverAdress = "http://13.95.159.138:8545";


    static String techUser1Address = "0x0085A7f13B649D9f89eB63f6f819ac0EF562c88D";
    static String techUser1Password = "tquser123!";

    static String techUser1Contract = "0x9A85899035e6FF53668FEf07b502dF7cA965f2C5";

    public static BigDecimal retrieveBalance() {
        Web3j web3 = Web3jFactory.build(new HttpService(serverAdress));


        try {
            EthGetBalance ethGetBalance = web3.ethGetBalance(techUser1Address, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger balance = ethGetBalance.getBalance();
            if (balance != null) {
                return new BigDecimal(balance).divide(new BigDecimal(("1000000000000000000")));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return BigDecimal.valueOf(-1);
    }

    public static boolean setName(String id, String name) throws IOException, CipherException, ExecutionException, InterruptedException {

        Parity parity = ParityFactory.build(new HttpService(serverAdress));
        parity.personalUnlockAccount(techUser1Address, techUser1Password).sendAsync().get();

        Web3j web3 = Web3jFactory.build(new HttpService(serverAdress));

        TransactionManager transactionManager = new ClientTransactionManager(web3, techUser1Address);

        RewardId contract = RewardId.load(techUser1Contract, web3, transactionManager, null, null);

        contract.setNewName(new Utf8String(name)).get();

        return true;
    }
}
