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
public class Alice {
    static final String PRIVATE_KEY = "0xa392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6";
    static final String PUBLIC_KEY =  "0a8a36cfcfaf801d50e6c0cd1167c84dcee79444080d3c26e96006b8fbace951427e20f92632e4ccb543ee6d0ae9b9ab8dae005a3b49b991b15f941808959678";
    static final ECKeyPair KEY_PAIR = new ECKeyPair(Numeric.toBigInt(PRIVATE_KEY), Numeric.toBigInt(PUBLIC_KEY));

    public static final Credentials CREDENTIALS = Credentials.create(KEY_PAIR);
    public static final String ADDRESS = CREDENTIALS.getAddress();
}
