package com.dicero.diceroller.core.coin.service;

import com.dicero.diceroller.core.coin.bean.Alice;
import com.dicero.diceroller.core.coin.bean.Bob;
import com.dicero.diceroller.core.coin.contracts.TxAttackWallet;
import com.dicero.diceroller.core.coin.util.Web3jConstants;
import com.dicero.diceroller.core.coin.util.Web3jUtils;
import org.apache.commons.lang3.StringUtils;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/9
 */
public class DiceContractService extends AbstractEthe {

    public DiceContractService(String [] args) {
        super(args);
    }

    public static void main(String [] args) throws Exception  {
        new DiceContractService(args).run();
        if(StringUtils.isBlank(contractTxAttackWalletAddress)) {
            deployTxAttackWalletContract();
        }
        loadTxAttackWalletContact();
    }

    public static String contractTxAttackWalletAddress = "0x89f5cf71f1914c2e74ac47b41abbc13059b8ddf0";

    public static BigInteger balanceOf(TxAttackWallet contract, String address, String msg) {
        try {
            BigInteger bigInteger = contract.balanceOf( address, address).send();
            System.out.println("// Contract 用户 (balanceOf-contract- " + msg + "): " + Web3jUtils.weiToEther(bigInteger));
            System.out.println("// Contract 用户 (balanceOf-china- " + msg + "): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, address)));
            System.out.println("// Contract 合约 (balanceOf-contract- " + msg + "): " + Web3jUtils.weiToEther(contract.balanceOf(contract.getContractAddress(), contract.getContractAddress()).send()));
            System.out.println("// Contract 合约 (balanceOf-china- " + msg + "): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, contract.getContractAddress())));
            System.out.println("// Contract Alice (balanceOf-contract- " + msg + "): " + Web3jUtils.weiToEther(contract.balanceOf(Alice.ADDRESS, Alice.ADDRESS).send()));
            System.out.println("// Contract Alice (balanceOf-china- " + msg + "): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, Alice.ADDRESS)));
//            System.out.println("// Contract 发送者地址 (sender-address): " + contract.sender().send());
//            System.out.println("// Contract 总数 (totalSupply): " + contract.totalSupply().send());
            return bigInteger;
        } catch (Exception e) { System.out.println("balanceOf : "); e.printStackTrace(); }
        return null;

    }


    public static void loadTxAttackWalletContact() {
        try {

            // NOTE: load 不花费gas
            System.out.println("// Contract Query (balanceOf-china-load合约之前): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, Bob.ADDRESS)));
            TxAttackWallet contract = TxAttackWallet
                    .load(contractTxAttackWalletAddress,
                            web3j,
                            Bob.CREDENTIALS,
                            Web3jConstants.GAS_PRICE,
                            Web3jConstants.GAS_LIMIT_GREETER_TX);

            BigInteger amount = Web3jUtils.etherToWei(new BigDecimal("0.1"));
            System.out.println("amountEther:" + Web3jUtils.weiToEther(amount));
            BigInteger payout = Web3jUtils.etherToWei(new BigDecimal("0.005"));
            System.out.println("// Contract Query (balanceOf-china-load合约之后): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, Bob.ADDRESS)));


            // FIXME: 交易
            try {
                TransactionReceipt txReceipt = contract.transferFrom(Alice.ADDRESS, Bob.ADDRESS, amount, payout).send();
                BigInteger deployFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);
                System.out.println("// Contract initial (transferFrom-fee): " + Web3jUtils.weiToEther(deployFees));
                balanceOf(contract, Bob.ADDRESS, "第一次transferFrom后查询");
            } catch (Exception e) { System.out.println("transferFrom : "); e.printStackTrace(); }


            // FIXME: 充值是否可以全部充值
//            try {
//                TransactionReceipt txReceipt = contract.depositToken(Bob.ADDRESS, amount).send();
//                BigInteger deployFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);
//
//                System.out.println("// Contract initial (depositToken-fee): " + Web3jUtils.weiToEther(deployFees));
//                balanceOf(contract, Bob.ADDRESS, "第一次充值后查询");
//            } catch (Exception e) { System.out.println("deposit : "); e.printStackTrace(); }

//            // FIXME: 充值是否可以全部充值 5.86055144
//            try {
//                TransactionReceipt txReceipt = contract.withdrawToken(Bob.ADDRESS, payout).send();
//                BigInteger deployFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);
//
//                System.out.println("// Contract initial (withdrawToken-fee): " + Web3jUtils.weiToEther(deployFees));
//                balanceOf(contract, Bob.ADDRESS, "第一次充值后查询");
//            } catch (Exception e) { System.out.println("deposit : "); e.printStackTrace(); }



            // FIXME: 转账给合约--失败
//            try {
//                balanceOf(contract, Bob.ADDRESS, "// tradeToContract 第一次交易前查询");
//                TransactionReceipt txReceipt = contract.tradeToContract(contract.getContractAddress(), amount).send();
//                BigInteger deployFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);
//
//                System.out.println("// Contract initial (tradeToContract-fees) : " + Web3jUtils.weiToEther(deployFees));
//                System.out.println("// Contract initial (tradeToContract-status): " + txReceipt.getStatus());
//                balanceOf(contract, Bob.ADDRESS, "// tradeToContract 第一次交易后查询");
//            } catch (Exception e) { System.out.println("tradeToContract : "); e.printStackTrace(); }


            // FIXME: 转账--失败
//            try {
//
//                System.out.println("// Contract initial (trade): " + contract.trade(Bob.ADDRESS, amount, payout, false).send());
//                balanceOf(contract, Bob.ADDRESS, "第一次交易后查询");
//                System.out.println("// Contract initial (trade): " + contract.depositToken(Bob.ADDRESS, amount).send());
//                balanceOf(contract, Bob.ADDRESS, "第二次交易后查询");
//            } catch (Exception e) { System.out.println("trade : "); e.printStackTrace(); }







//            for(int i=0;i<3;i++) {
//                balanceOf(contract, Bob.ADDRESS,"第"+i+"次查询");
//
//                try {
//                    System.out.println("// Contract initial (tradeToken)" + i + "): " + contract.tradeToken(Bob.ADDRESS, amount).send());
//                } catch (Exception e) { System.out.println("tradeToken : "); e.printStackTrace(); }
//            }


//        try {
//
//            // get tx receipt
//            TransactionReceipt depositTxReceipt = contract.depositToken(Bob.ADDRESS, amount).send();
//            for (TxAttackWallet.DepositEventResponse depositEventResponse: contract.getDepositEvents(depositTxReceipt)) {
//                System.out.println("DepositEventResponse value: " + ToStringBuilder.reflectionToString(depositEventResponse, ToStringStyle.SHORT_PREFIX_STYLE));
//            }
//            System.out.println("// Contract initial (depositToken): " + depositTxReceipt.getLogs().toString());
//        } catch (Exception e) {
//            System.out.println("1 : "); e.printStackTrace(); }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static TxAttackWallet deployTxAttackWalletContract() throws Exception {
        System.out.println("// Deploy contract TxAttackWallet");


        System.out.println("// Deploy Before: " + Web3jUtils.getBalanceWei(web3j, Alice.ADDRESS));

        TxAttackWallet contract = TxAttackWallet
                .deploy(
                        web3j,
                        Alice.CREDENTIALS,
                        Web3jConstants.GAS_PRICE,
                        Web3jConstants.GAS_LIMIT_GREETER_TX)
                .send();



        // get tx receipt
        TransactionReceipt txReceipt = contract
                .getTransactionReceipt()
                .get();



        // get tx hash and tx fees
        String deployHash = txReceipt.getTransactionHash();
        BigInteger deployFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);

        System.out.println("Deploy hash: " + deployHash);
        System.out.println("Deploy fees: " + Web3jUtils.weiToEther(deployFees));

        System.out.println("// Deploy After" + Web3jUtils.getBalanceWei(web3j, Alice.ADDRESS));

        contractTxAttackWalletAddress = contract.getContractAddress();
        System.out.println("// Contract address: ====================" );
        System.out.println("// Contract address: " + contractTxAttackWalletAddress);
        System.out.println("// Contract address: ====================" );
        System.out.println("// Contract address balance (initial-china): " + Web3jUtils.getBalanceWei(web3j, contractTxAttackWalletAddress));


        return contract;
    }

    public static void deposit(TxAttackWallet contract, String fromAddress, BigInteger amountWei) throws Exception {
        System.out.println("// Deposit Send " +Web3jUtils.weiToEther(amountWei)+ " Ethers to contract");
        System.out.println("// Deposit Send Contract address balance (before funding): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, contract.getContractAddress())));

        // step 1: get the nonce (tx count for sending address)
        EthGetTransactionCount transactionCount = web3j
                .ethGetTransactionCount(fromAddress, DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();

        BigInteger nonce = transactionCount.getTransactionCount();
        System.out.println("// Deposit Send Nonce for sending address (coinbase): " + nonce);

        // step 2: create the transaction object
        Transaction transaction = Transaction
                .createEtherTransaction(
                        fromAddress,
                        nonce,
                        Web3jConstants.GAS_PRICE,
                        Web3jConstants.GAS_LIMIT_ETHER_TX,
                        contract.getContractAddress(),
                        amountWei);

        // step 3: send the tx to the network
        EthSendTransaction response = web3j
                .ethSendTransaction(transaction)
                .sendAsync()
                .get();

        String txHash = response.getTransactionHash();
        System.out.println("// Deposit Send Tx hash: " + txHash);

        // step 4: wait for the confirmation of the network
        TransactionReceipt receipt = Web3jUtils.waitForReceipt(web3j, txHash);

        BigInteger gasUsed = receipt.getCumulativeGasUsed();
        System.out.println("// Deposit Send Tx cost: " + gasUsed + " Gas (" + Web3jUtils.weiToEther(gasUsed.multiply(Web3jConstants.GAS_PRICE)) +" Ether)\n");

        System.out.println("// Deposit Send Contract address balance (after funding): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, contract.getContractAddress())));
    }


}
