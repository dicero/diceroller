package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/1
 */
public enum OuterAccountEnums {

    PLATFORM("29999999999");

    private String memberId;

    OuterAccountEnums(String memberId) {
        this.memberId = memberId;
    }

    public static String get201Account(String memberId) {
        return "200100001" + memberId + "20010000";
    }
}
