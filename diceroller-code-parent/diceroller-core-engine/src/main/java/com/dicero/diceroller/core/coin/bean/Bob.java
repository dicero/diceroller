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
    private static final String PRIVATE_KEY = "782c33c02523ea0da353a6e4a931d9659f60dedd54fedffa65464a48bc41eeaa";
    private static final String PUBLIC_KEY = "";
    static final ECKeyPair KEY_PAIR = new ECKeyPair(Numeric.toBigInt(PRIVATE_KEY), Numeric.toBigInt(PUBLIC_KEY));

    public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
    public static final String ADDRESS = CREDENTIALS.getAddress();
}
