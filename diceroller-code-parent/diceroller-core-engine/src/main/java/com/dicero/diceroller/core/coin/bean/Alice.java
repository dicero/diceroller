package com.dicero.diceroller.core.coin.bean;

import com.dicero.diceroller.common.util.EncryptUtil;
import org.web3j.crypto.Credentials;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class Alice {
    static final String PRIVATE_KEY = "336d5149928f21592503f662cd43434093261cc4b486fdc488170248d6f31610";

    public static final Credentials CREDENTIALS = Credentials.create(EncryptUtil.SHA256(PRIVATE_KEY+"1"));
    public static final String ADDRESS = CREDENTIALS.getAddress();
}
