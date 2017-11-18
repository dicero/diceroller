package com.dicero.diceroller.core.coin.bean;

import org.web3j.crypto.Credentials;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class Alice {
    static final String PRIVATE_KEY = "c5dd0a8878d5e5f6e8f92181d8fe0b233a7bfb0f87a0c7369c740f7ede610c18";

    public static final Credentials CREDENTIALS = Credentials.create(PRIVATE_KEY);
    public static final String ADDRESS = CREDENTIALS.getAddress();
}
