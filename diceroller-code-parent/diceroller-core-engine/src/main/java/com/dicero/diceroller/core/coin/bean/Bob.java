package com.dicero.diceroller.core.coin.bean;

import org.web3j.crypto.Credentials;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class Bob {
    private static final String PRIVATE_KEY = "857500cac13f07421326bee7cd09151e7c7e24a57022889558418fad6e85e07a";
//    private static final String PUBLIC_KEY = "";
//    static final ECKeyPair KEY_PAIR = new ECKeyPair(Numeric.toBigInt(PRIVATE_KEY), Numeric.toBigInt(PUBLIC_KEY));

    public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
    public static final String ADDRESS = CREDENTIALS.getAddress();
}
