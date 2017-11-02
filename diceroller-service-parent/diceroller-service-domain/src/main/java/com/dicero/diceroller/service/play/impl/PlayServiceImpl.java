package com.dicero.diceroller.service.play.impl;

import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.service.play.PlayService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * <p></p>
 当前种子对
 用户种子
 13612799814343
 服务器种子sha-256散列
 779176bd344b41a2b7f9c508c84a295670aa995f73201ac0fe99384e62c84f55
 ------------------------------------------------------------------------------------------
 以往种子配对
 用户种子
 5162163102898
 服务器种子
 1481c95e15e1ca2b0f1abe61c26c1c571cb799b5015e0fc3b18eae7d7610b276
 服务器种子sha-256散列
 8bd4ad65e79cb6b3b2e283aad771fe44c76548f7b2d60b8fe4927c244529450a
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
