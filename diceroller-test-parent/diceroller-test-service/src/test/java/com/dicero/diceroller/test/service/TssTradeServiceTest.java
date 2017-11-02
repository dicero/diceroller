package com.dicero.diceroller.test.service;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.service.tss.TssTradeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
public class TssTradeServiceTest extends TestBase {
    @Autowired
    TssTradeService tssTradeService;

    @Test
    public void tradeTest(){
        tssTradeService.trade();
    }


}
