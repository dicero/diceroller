package com.dicero.diceroller.core.coin.bean;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.utils.Numeric;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class Bob {
    static final String PRIVATE_KEY = "0x063CB410F97b11959277664FCAf4cf5DEdC0A900";
    static final String PUBLIC_KEY =  "48a0fc2ac34452bac2ecdb3a2e8b23e4b60d510c83f58d56174b08344183a598920f457f8caff5f1d50bab618a43d22e9f0a17cb85592746fa6eb28964a554b3";
    static final ECKeyPair KEY_PAIR = new ECKeyPair(Numeric.toBigInt(PRIVATE_KEY), Numeric.toBigInt(PUBLIC_KEY));

    public static final Credentials CREDENTIALS = Credentials.create(KEY_PAIR);
    public static final String ADDRESS = CREDENTIALS.getAddress();
}
