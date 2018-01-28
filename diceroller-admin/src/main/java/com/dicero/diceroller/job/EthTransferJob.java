package com.dicero.diceroller.job;

import com.dicero.diceroller.core.coin.service.EtheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthTransaction;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p></p>
 *
 * @author znz
 * @version 2018/1/28
 */
@Slf4j
@Component
public class EthTransferJob {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
//         EtheService.web3j().ethBlockNumber();
//         EtheService.web3j().ethGetBlockByNumber()
//        EtheService.web3j().ethGetBlockTransactionCountByHash();
        try {

            EthTransaction ethTransaction = EtheService.web3j().ethGetTransactionByBlockNumberAndIndex(DefaultBlockParameter.valueOf(BigInteger.ONE), BigInteger.ONE).send();
            ethTransaction.getResult().getFrom();
        } catch (Exception e) {

        }

    }
}
