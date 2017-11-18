package com.dicero.diceroller.test.core;


import com.dicero.diceroller.core.coin.bean.Alice;
import com.dicero.diceroller.core.coin.bean.Bob;
import com.dicero.diceroller.core.coin.contracts.Greeter;
import com.dicero.diceroller.core.coin.util.Web3jConstants;
import com.dicero.diceroller.core.coin.util.Web3jUtils;
import org.junit.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class DeployGreeterTest  extends AbstractEtheTest {

    static final String MESSAGE = "hello world";

    @Test
    public void testDeployGreeter() throws Exception {

        // move funds to contract owner (amount in wei) to deploy the contract
        String contractOwnerAdress = Alice.ADDRESS;
        BigInteger initialBalance = BigInteger.valueOf(25_000_000_000_000_000L);
        ensureFunds(contractOwnerAdress, initialBalance);

        BigInteger ownerBalanceBeforeDeploy = getBalanceWei(contractOwnerAdress);
        System.out.println("Contract owner balance (pre-deploy): " + ownerBalanceBeforeDeploy);

        // test (1) deploy the contract with the owner's credentials
        Credentials credentials = Alice.CREDENTIALS;

        // deploy the greeter contract
        Greeter contract = Greeter
                .deploy(
                        web3j,
                        credentials,
                        Web3jConstants.GAS_PRICE,
                        Web3jConstants.GAS_LIMIT_GREETER_TX,
                        MESSAGE)
                .send();

        assertNotNull(contract);
        TransactionReceipt txReceipt = contract
                .getTransactionReceipt()
                .get();

        String deployHash = txReceipt.getTransactionHash();
        BigInteger deployFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);
        BigInteger expectedBalanceAfterDeploy = ownerBalanceBeforeDeploy.subtract(deployFees);
        BigInteger actualBalanceAfterDeploy = getBalanceWei(contractOwnerAdress);
        assertEquals("Unexpected contract owner balance after contract deploy", expectedBalanceAfterDeploy, actualBalanceAfterDeploy);
        System.out.println("Deploy hash: " + deployHash);
        System.out.println("Deploy fees: " + deployFees);

        // get contract address (after deploy)
        String contractAddress = contract.getContractAddress();
        assertNotNull(contractAddress);

        // get number of deposits
//        Uint256 deposits = contract.
//                .deposits()
//                .get();

//        assertEquals("Unexpected number of deposits", BigInteger.ZERO, deposits.getValue());

        System.out.println("Contract address: " + contractAddress);
        System.out.println("Contract address balance (initial): " + getBalanceWei(contractAddress));
//        System.out.println("Contract.deposits(): " + deposits.getValue());
        System.out.println("Contract owner balance (post-deploy): " + getBalanceWei(contractOwnerAdress));


        // test (2) standard ether transfer to contract address
        BigInteger contractFundingAmount = BigInteger.valueOf(123_456);
        Web3jUtils.transferFromCoinbaseAndWait(web3j, contractAddress, contractFundingAmount);

//        deposits = contract
//                .deposits()
//                .get();

        assertEquals("Contract address failed to receive proper amount of funds", contractFundingAmount, getBalanceWei(contractAddress));
//        assertEquals("Unexpected number of deposits", BigInteger.ONE, deposits.getValue());
        System.out.println("Contract address balance (after transfer): " + getBalanceWei(contractAddress));
//        System.out.println("Contract.deposits(): " + deposits.getValue());
        System.out.println("Contract owner balance (after transfer): " + getBalanceWei(contractOwnerAdress));

        // test (3) call contract method greet()
        String message = contract
                .greet()
                .send();

        assertNotNull(message);
        assertEquals("Wrong message returned", MESSAGE, message.toString());
        System.out.println("Contract.greet() for contract owner: " + message.toString());
        System.out.println("Contract address balance (after greet): " + getBalanceWei(contractAddress));

        // test (4) loading and using contract from existing address
        ensureFunds(Bob.ADDRESS, initialBalance);

        Greeter contractLoaded = Greeter
                .load(
                        contractAddress,
                        web3j,
                        Bob.CREDENTIALS,
                        Web3jConstants.GAS_PRICE,
                        Web3jConstants.GAS_LIMIT_GREETER_TX);

        String messageFromLoaded = contractLoaded
                .greet()
                .send();

        assertNotNull(messageFromLoaded);
        assertEquals("Wrong message returned", MESSAGE, messageFromLoaded.toString());
        System.out.println("Contract.greet() for bob using contract: " + messageFromLoaded.toString());

        // test (5) kill contract
        BigInteger ownerBalanceBeforeKill = getBalanceWei(contractOwnerAdress);
        txReceipt = contract
                .kill()
                .send();

        assertNotNull(txReceipt);
        BigInteger killFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);
        BigInteger expectedBalanceAfterKill = ownerBalanceBeforeKill.add(contractFundingAmount).subtract(killFees);
        BigInteger actualBalanceAfterKill = getBalanceWei(contractOwnerAdress);

        assertEquals("Unexpected contract owner balance after killing contract", actualBalanceAfterKill, expectedBalanceAfterKill);
        System.out.println("Contract address balance (after kill): " + getBalanceWei(contractAddress));
        System.out.println("Contract owner balance (after kill): " + getBalanceWei(contractOwnerAdress));

        // test (6) try to run greet again (expect ExecutionException)
        exception.expect(ExecutionException.class);
        try {
            message = contract
                    .greet()
                    .send();
        }
        catch(Exception e) {
            System.out.println("Ok case: failed to call greet() on killed contract: " + e);
            throw e;
        }
    }
}
