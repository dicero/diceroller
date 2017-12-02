package com.dicero.diceroller.test.core;

import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.core.coin.util.Web3jConstants;
import org.junit.Test;
import org.web3j.crypto.*;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class CreateHDAccountTest extends AbstractEtheTest {
    public static void main(String[] args) {
        String seed = RandomUtil.randomStringOrNumber(128);
        System.out.println("seed " + seed);
        String hash = EncryptUtil.SHA256(seed);
        System.out.println("hash " + hash);
        String privateKey = "";
        String publicKey = "";
    }

    @Test
    public void testCreateHDAccountFromScratch() throws Exception {

        // create new private/public key pair
        String seed = EncryptUtil.SHA256("hello");
        String privateKey = "";
        String publicKey = "";

        // create credentials + address from private/public key pair
        Credentials credentials = Credentials.create(privateKey, publicKey);
        String address = credentials.getAddress();

        // print resulting data of new account
        System.out.println("private key: '" + privateKey + "'");
        System.out.println("public key: '" + publicKey + "'");
        System.out.println("address: '" + address + "'\n");

        // test (1) check if it's possible to transfer funds to new address
        BigInteger amountWei = Convert.toWei("0.131313", Convert.Unit.ETHER).toBigInteger();
        transferWei(getCoinbase(), address, amountWei);

        BigInteger balanceWei = getBalanceWei(address);
        BigInteger nonce = getNonce(address);

        assertEquals("Unexpected nonce for 'to' address", BigInteger.ZERO, nonce);
        assertEquals("Unexpected balance for 'to' address", amountWei, balanceWei);

        // test (2) funds can be transferred out of the newly created account
        BigInteger txFees = Web3jConstants.GAS_LIMIT_ETHER_TX.multiply(Web3jConstants.GAS_PRICE);
        RawTransaction txRaw = RawTransaction
                .createEtherTransaction(
                        nonce,
                        Web3jConstants.GAS_PRICE,
                        Web3jConstants.GAS_LIMIT_ETHER_TX,
                        getCoinbase(),
                        amountWei.subtract(txFees));

        // sign raw transaction using the sender's credentials
        byte[] txSignedBytes = TransactionEncoder.signMessage(txRaw, credentials);
        String txSigned = Numeric.toHexString(txSignedBytes);

        // send the signed transaction to the ethereum client
        EthSendTransaction ethSendTx =  web3j.ethSendRawTransaction(txSigned).sendAsync().get();

        Response.Error error = ethSendTx.getError();
        String txHash = ethSendTx.getTransactionHash();
        assertNull(error);
        assertFalse(txHash.isEmpty());

        waitForReceipt(txHash);

        assertEquals("Unexpected nonce for 'to' address", BigInteger.ONE, getNonce(address));
        assertTrue("Balance for 'from' address too large: " + getBalanceWei(address), getBalanceWei(address).compareTo(txFees) < 0);
    }
}
