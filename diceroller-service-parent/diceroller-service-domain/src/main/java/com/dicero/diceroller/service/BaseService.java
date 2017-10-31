package com.dicero.diceroller.service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public class BaseService {
    public static Timestamp now = new Timestamp(new Date().getTime());
}
