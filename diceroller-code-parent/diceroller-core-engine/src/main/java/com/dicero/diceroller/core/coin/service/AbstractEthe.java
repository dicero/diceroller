package com.dicero.diceroller.core.coin.service;


import com.dicero.diceroller.core.coin.util.Web3jConstants;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class AbstractEthe {

    static Web3j web3j = null;
    static String clientUrl = null;

    public AbstractEthe(String [] args) {
        clientUrl = argsToUrl(args);
        web3j = Web3j.build(new HttpService(clientUrl));
    }

    public String argsToUrl(String [] args) {
        String ip = Web3jConstants.CLIENT_IP;
        String port = Web3jConstants.CLIENT_PORT;

        if(args.length >= 1) { ip = args[0]; }
        if(args.length >= 2) { port = args[1]; }

        return String.format("http://%s:%s", ip, port);
    }

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
        });



        // NOTE: To receive all new transactions as they are added to the blockchain:
        Subscription subscription2 = web3j.transactionObservable().subscribe(tx -> {
            System.out.println("To receive all new transactions: " + tx);
            System.out.println("To receive all new transactions getFrom: " + tx.getFrom());
            System.out.println("To receive all new transactions getPublicKey: " + tx.getPublicKey());
            System.out.println("To receive all new transactions getGas: " + tx.getGas());
        });

        // NOTE: To receive all pending transactions as they are submitted to the network (i.e. before they have been grouped into a block together):
        Subscription subscription3 = web3j.pendingTransactionObservable().subscribe(tx -> {
            System.out.println("To receive all pending transactions: " + tx);
        });

    };
}
