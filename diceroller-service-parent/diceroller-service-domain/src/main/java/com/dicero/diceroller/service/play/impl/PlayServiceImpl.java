package com.dicero.diceroller.service.play.impl;

import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.service.play.PlayService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
public class PlayServiceImpl implements PlayService{

    @Override
    public String createClientSeed() {
        // NOTE: 13612799814343 , 14
        return System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(1) ;
    }

    @Override
    public String createServerSeed() {
        return EncryptUtil.SHA256("dice1099322Y" + System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(6) );
    }

    @Override
    public boolean roller() {
        return false;
    }


}
