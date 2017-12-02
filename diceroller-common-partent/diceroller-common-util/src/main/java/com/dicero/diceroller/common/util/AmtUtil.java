package com.dicero.diceroller.common.util;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/2
 */
public class AmtUtil {

    public static int compareTo(BigDecimal a, BigDecimal b){
        return a.setScale(8, BigDecimal.ROUND_HALF_UP).compareTo(b.setScale(8, BigDecimal.ROUND_HALF_UP));
    }

    public static BigDecimal checkAmt(BigDecimal a){
        return check(a, 8);
    }

    public static BigDecimal check(BigDecimal a, int roundingMode){
        return a.setScale(roundingMode, BigDecimal.ROUND_HALF_UP);
    }
}
