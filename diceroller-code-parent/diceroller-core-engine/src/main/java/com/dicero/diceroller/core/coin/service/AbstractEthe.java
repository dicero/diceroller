package com.dicero.diceroller.core.coin.service;


import com.dicero.diceroller.core.coin.util.Web3jUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import rx.Subscription;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class AbstractEthe {

    static Web3j web3j = null;

    public AbstractEthe(String [] args) {
        web3j = EtheService.web3j();
    }

    private static int count = 1;
    public void run() throws Exception {

        // show client details
        Web3ClientVersion client = web3j
                .web3ClientVersion()
                .sendAsync()
                .get();

        System.out.println("Connected to " + client.getWeb3ClientVersion() + "\n");


        // Note: filters are not supported on Infura.

        // NOTE: To receive all new blocks as they are added to the blockchain:
        Subscription subscription = web3j.blockObservable(false).subscribe(tx -> {
            System.out.println("To receive all new blocks: " + tx);
            tx.getBlock().getAuthor();

        });


        // NOTE: To receive all new transactions as they are added to the blockchain:
        Subscription subscription2 = web3j.transactionObservable().subscribe(tx -> {
            System.out.println("["+count + "]To receive all new transactions: " + tx);
            System.out.println("["+count + "]To receive all new transactions getFrom: " + tx.getFrom());
            System.out.println("["+count + "]To receive all new transactions getTo: " + tx.getTo());
            System.out.println("["+count + "]To receive all new transactions getValue: " + Web3jUtils.weiToEther(tx.getValue()));
            System.out.println("["+count + "]To receive all new transactions getGas: " + tx.getGas());
            System.out.println("["+count + "]To receive all new transactions getGasPrice: " + tx.getGasPrice());
            System.out.println("["+count + "]To receive all new transactions getHash: " + tx.getHash());
            count++;
        });

        // NOTE: To receive all pending transactions as they are submitted to the network (i.e. before they have been grouped into a block together):
        Subscription subscription3 = web3j.pendingTransactionObservable().subscribe(tx -> {
//            System.out.println("To receive all pending transactions: " + tx);
        });

    };
}
