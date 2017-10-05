package collabothon.rewardchain;

import android.util.Log;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

/**
 * Created by henrik on 05.10.17.
 */

public class ChainDAO {

    public static BigInteger retriveBalance() {
        Web3j web3 = Web3jFactory.build(new HttpService("http://13.95.159.138:8545"));

        String address = "0x0085A7f13B649D9f89eB63f6f819ac0EF562c88D";

        try {
            EthGetBalance ethGetBalance = web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger balance = ethGetBalance.getBalance();
            if (balance != null) {
                return balance.divide(new BigInteger(("1000000000000000000")));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return BigInteger.valueOf(-1);
    }
}
