package com.dicero.diceroller.core.coin.service;

import com.dicero.diceroller.core.coin.bean.Alice;
import com.dicero.diceroller.core.coin.bean.Bob;
import com.dicero.diceroller.core.coin.contracts.FixedSupplyToken;
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
public class FixedSupplyTokenTest extends AbstractEthe {

    public FixedSupplyTokenTest(String [] args) {
        super(args);
    }

    public static void main(String [] args) throws Exception  {
        new FixedSupplyTokenTest(args).run();
        if(StringUtils.isBlank(contractTxAttackWalletAddress)) {
            deployFixedSupplyTokenContract();
        }
        loadFixedSupplyTokenContact();
    }

    public static String contractTxAttackWalletAddress = "";

    public static BigInteger balanceOf(FixedSupplyToken contract, String address, String msg) {
        try {
            BigInteger bigInteger = contract.balanceOf( address ).send();
            System.out.println("// Contract 用户 (balanceOf-contract- " + msg + "): " + Web3jUtils.weiToEther(bigInteger));
            System.out.println("// Contract 用户 (balanceOf-china- " + msg + "): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, address)));
            System.out.println("// Contract 合约 (balanceOf-contract- " + msg + "): " + Web3jUtils.weiToEther(contract.balanceOf(contract.getContractAddress()).send()));
            System.out.println("// Contract 合约 (balanceOf-china- " + msg + "): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, contract.getContractAddress())));
            System.out.println("// Contract Alice (balanceOf-contract- " + msg + "): " + Web3jUtils.weiToEther(contract.balanceOf(Alice.ADDRESS).send()));
            System.out.println("// Contract Alice (balanceOf-china- " + msg + "): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, Alice.ADDRESS)));
//            System.out.println("// Contract 发送者地址 (sender-address): " + contract.sender().send());
//            System.out.println("// Contract 总数 (totalSupply): " + contract.totalSupply().send());
            return bigInteger;
        } catch (Exception e) { System.out.println("balanceOf : "); e.printStackTrace(); }
        return null;

    }


    public static void loadFixedSupplyTokenContact() {
        try {

            // NOTE: load 不花费gas
            System.out.println("// Contract Query (balanceOf-china-load合约之前): " + Web3jUtils.weiToEther(Web3jUtils.getBalanceWei(web3j, Bob.ADDRESS)));
            FixedSupplyToken contract = FixedSupplyToken
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
                TransactionReceipt txReceipt = contract.transferFrom(Alice.ADDRESS, Bob.ADDRESS, amount).send();
                BigInteger deployFees = txReceipt.getCumulativeGasUsed().multiply(Web3jConstants.GAS_PRICE);
                System.out.println("// Contract initial (transferFrom-fee): " + Web3jUtils.weiToEther(deployFees));
                balanceOf(contract, Bob.ADDRESS, "第一次transferFrom后查询");
            } catch (Exception e) { System.out.println("transferFrom : "); e.printStackTrace(); }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static TxAttackWallet deployFixedSupplyTokenContract() throws Exception {
        System.out.println("// Deploy contract FixedSupplyToken");


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
