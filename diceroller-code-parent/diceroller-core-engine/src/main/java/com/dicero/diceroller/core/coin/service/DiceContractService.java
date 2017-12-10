package com.dicero.diceroller.core.coin.service;

import com.dicero.diceroller.core.coin.bean.Alice;
import com.dicero.diceroller.core.coin.bean.Bob;
import com.dicero.diceroller.core.coin.bean.Jack;
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
//        for (int i=0; i<3;i++) {
        loadTxAttackWalletContact();
//        }

//        if(StringUtils.isBlank(contractTokenAddress)) {
//            deployTokenContract();
//        }

//        for (int i=0; i<3;i++) {
//        loadTxAttackWalletContact();
//        loadTokenContact();
//        }
    }


    public static String contractTxAttackWalletAddress = "0x6e3863416c68349e55b0e9cd0033bf35398e94cc";

    public static void loadTxAttackWalletContact() {



        try {

//            System.out.println("Before loadContact:" + Web3jUtils.getBalanceWei(web3j, Alice.ADDRESS));
            TxAttackWallet contract = TxAttackWallet
                    .load(contractTxAttackWalletAddress,
                            web3j,
                            Bob.CREDENTIALS,
                            Web3jConstants.GAS_PRICE,
                            Web3jConstants.GAS_LIMIT_GREETER_TX);
            System.out.println("// Alice LoadContract Contract owner: " + contract.getOwner().send() );
            System.out.println("// Alice LoadContract Contract sender: " + contract.getSender().send() );


            TransactionReceipt transactionReceipt = contract.sendCoin(Jack.ADDRESS, Web3jUtils.etherToWei(new BigDecimal(0.01))).send();
            System.out.println("GasUsed:" + transactionReceipt.getGasUsed());
            System.out.println("Status:" + transactionReceipt.getStatus());
            System.out.println("TransactionReceipt:" + transactionReceipt);

//            TransactionReceipt transactionReceipt = contract.transferTo(Bob.ADDRESS, Jack.ADDRESS, Web3jUtils.etherToWei(new BigDecimal(0.01))).send();
//
//            System.out.println("From:" + transactionReceipt.getFrom());
//            System.out.println("To:" + transactionReceipt.getTo());
//            System.out.println("After Bob ownerBalance:" + Web3jUtils.getBalanceWei(web3j, Bob.ADDRESS));
//            System.out.println("After Jack ownerBalance:" + Web3jUtils.getBalanceWei(web3j, Jack.ADDRESS));



//            System.out.println("After ownerBalance:" + contract.getOwnerBalance().send());
//            System.out.println("After senderBalance:" + contract.getSenderBalance().send());
            /**
             * Before ownerBalance:100380840960000000000
             * Before senderBalance:115792089237316195423570985008687907853269984665640564039455084007913129639935
             *
             *  After ownerBalance:100380840960000000000
             *  After senderBalance:115792089237316195423570985008687907853269984665640564039455084007913129639935
             *
             */
//            BigInteger ownerBalance = contract.getOwnerBalance().send();
//            BigInteger senderBalance = contract.getSenderBalance(Bob.ADDRESS).send();
//            System.out.println("ownerBalance:" + Web3jUtils.getBalanceWei(web3j, Alice.ADDRESS));
//            System.out.println("senderBalance:" + Web3jUtils.getBalanceWei(web3j, Bob.ADDRESS));
//            System.out.println("ownerBalance (ether):" + Web3jUtils.weiToEther(ownerBalance));
//            System.out.println("senderBalance (ether):" + Web3jUtils.weiToEther(senderBalance));
//            TransactionReceipt transactionReceipt = contract.transferTo(Bob.ADDRESS, Web3jUtils.etherToWei(new BigDecimal("0.000002"))).send();
//            System.out.println("senderBalance:" + Web3jUtils.getBalanceWei(web3j, Bob.ADDRESS));
//
//            for (TxAttackWallet.AuctionTransferToEventResponse eventResponse: contract.getAuctionTransferToEvents(transactionReceipt)) {
//                System.out.println("sender: " + eventResponse.sender);
//                System.out.println("amount: " + eventResponse.amount);
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public static TxAttackWallet deployTxAttackWalletContract() throws Exception {
        System.out.println("// Deploy contract TxAttackWallet");


        System.out.println("// Deploy Before" + Web3jUtils.getBalanceWei(web3j, Alice.ADDRESS));

        TxAttackWallet contract = TxAttackWallet
                .deploy(
                        web3j,
                        Alice.CREDENTIALS,
                        Web3jConstants.GAS_PRICE,
                        Web3jConstants.GAS_LIMIT_GREETER_TX,
                        Web3jUtils.etherToWei(new BigDecimal(0.01)),
                        Bob.ADDRESS)
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
        System.out.println("// Contract owner: " + contract.getOwner().send() );
        System.out.println("// Contract sender: " + contract.getSender().send() );
        System.out.println("// Contract address: " + contractTxAttackWalletAddress);
        System.out.println("// Contract address: ====================" );
        System.out.println("// Contract address balance (initial): " + Web3jUtils.getBalanceWei(web3j, contractTxAttackWalletAddress));

        return contract;
    }


}
