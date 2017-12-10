package com.dicero.diceroller.core.coin.bean;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.utils.Numeric;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/9
 */
public class Jack {
    static final String PRIVATE_KEY = "8580db39488533f4209f0d382c09d4abe38e003b27d9ce4a81dcbab293c6832c";
    static final String PUBLIC_KEY =  "e7788d00f68c32f39ffcdf826f2418e4bce5249c7c35387b384a2e98f4b5b06908abd84ac40af51649e1a674435784fe7c7c9a0e304a7eafa9f87bf96c41f73a";
    static final ECKeyPair KEY_PAIR = new ECKeyPair(Numeric.toBigInt(PRIVATE_KEY), Numeric.toBigInt(PUBLIC_KEY));

    public static final Credentials CREDENTIALS = Credentials.create(KEY_PAIR);
    public static final String ADDRESS = CREDENTIALS.getAddress();
}
