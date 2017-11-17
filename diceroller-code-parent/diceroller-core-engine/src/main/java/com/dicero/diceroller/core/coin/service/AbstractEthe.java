package com.dicero.diceroller.core.coin.service;


import com.dicero.diceroller.core.coin.util.Web3jConstants;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
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
    };
}
