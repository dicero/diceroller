package com.dicero.diceroller.core.coin.service;

import com.dicero.diceroller.core.coin.util.Web3jConstants;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

/**
 * <p>eth service</p>
 *
 * @author znz
 * @version 2018/1/28
 */
@Slf4j
public class EtheService {
    static Web3j web3j = null;

    public static Web3j web3j() {

        // TODO: 换成正式版本
        if (web3j == null) {
            String clientUrl = argsToUrl();
            OkHttpClient httpClient = createOkHttpClient();
            HttpService httpService = new HttpService(httpClient);
            web3j = Web3j.build(httpService);


        }

        try {
            // show client details
            Web3ClientVersion client = web3j
                    .web3ClientVersion()
                    .sendAsync()
                    .get();

            System.out.println("Connected to " + client.getWeb3ClientVersion() + "\n");
        } catch (Exception e) {
            log.error("Start Web3j", e);
        }


        return web3j;
    }

    private static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.build();
    }

    private static String argsToUrl() {
        String ip = Web3jConstants.CLIENT_IP;
        String port = Web3jConstants.CLIENT_PORT;

        return String.format("http://%s:%s", ip, port);
    }

}
