package com.dicero.diceroller.core.coin.service;

import com.dicero.diceroller.core.coin.bean.Alice;
import com.dicero.diceroller.core.coin.bean.Bob;
import com.dicero.diceroller.core.coin.contracts.TxAttackWallet;
import com.dicero.diceroller.core.coin.util.Web3jConstants;
import com.dicero.diceroller.core.coin.util.Web3jUtils;
import org.apache.commons.lang3.StringUtils;
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


    public static String contractTxAttackWalletAddress = "";

    public static BigInteger balanceOf(TxAttackWallet contract, String address, String msg) {
        try {
            BigInteger bigInteger = contract.balanceOf( address, address).send();
            System.out.println("// Contract Query (balanceOf-contract- " + msg + "): " + bigInteger);
            System.out.println("// Contract Query (balanceOf-china- " + msg + "): " + Web3jUtils.getBalanceWei(web3j, address));
            return bigInteger;
        } catch (Exception e) { System.out.println("balanceOf : "); e.printStackTrace(); }
        return null;
    }

    public static BigInteger voterSupply(TxAttackWallet contract, String address, String msg) {
        try {
            BigInteger bigInteger = contract.voterSupply( address ).send();
            System.out.println("// Contract Query (balanceOf-contract- " + msg + "): " + bigInteger);
            System.out.println("// Contract Query (balanceOf-china- " + msg + "): " + Web3jUtils.getBalanceWei(web3j, address));
            return bigInteger;
        } catch (Exception e) { System.out.println("voterSupply : "); e.printStackTrace(); }
        return null;
    }


    public static void loadTxAttackWalletContact() {
        try {


            System.out.println("// Contract Query (balanceOf-china-提交合约之前): " + Web3jUtils.getBalanceWei(web3j, Bob.ADDRESS));
            TxAttackWallet contract = TxAttackWallet
                    .load(contractTxAttackWalletAddress,
                            web3j,
                            Bob.CREDENTIALS,
                            Web3jConstants.GAS_PRICE,
                            Web3jConstants.GAS_LIMIT_GREETER_TX);

            BigInteger amount = Web3jUtils.etherToWei(new BigDecimal("0.1"));


            try {
                System.out.println("// Contract initial (build): " + contract.build(Bob.ADDRESS).send());
            } catch (Exception e) { System.out.println("build : "); e.printStackTrace(); }


            voterSupply(contract, Bob.ADDRESS, "充值之前查询");
//
//            try {
//
//                System.out.println("// Contract initial (deposit): " + contract.depositToken(Bob.ADDRESS, amount).send());
//                voterSupply(contract, Bob.ADDRESS, "第一次充值后查询");
//                System.out.println("// Contract initial (deposit): " + contract.depositToken(Bob.ADDRESS, amount).send());
//                voterSupply(contract, Bob.ADDRESS, "第二次充值后查询");
//            } catch (Exception e) { System.out.println("deposit : "); e.printStackTrace(); }



//            balanceOf(contract, Bob.ADDRESS, "充值之前查询");
//
//            try {
//                System.out.println("// Contract initial (deposit): " + contract.depositToken(Bob.ADDRESS, amount).send());
//                balanceOf(contract, Bob.ADDRESS, "第一次充值后查询");
//                System.out.println("// Contract initial (deposit): " + contract.depositToken(Bob.ADDRESS, amount).send());
//                balanceOf(contract, Bob.ADDRESS, "第二次充值后查询");
//            } catch (Exception e) { System.out.println("deposit : "); e.printStackTrace(); }




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


}
