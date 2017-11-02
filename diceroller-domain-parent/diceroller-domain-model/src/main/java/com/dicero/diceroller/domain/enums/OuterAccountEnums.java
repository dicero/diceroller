package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/1
 */
public enum OuterAccountEnums {

    PLATFORM("平台账户",1999999999);

    private String name;
    private int memberId;

    OuterAccountEnums(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public static String get201Account(int memberId) {
        return "200100001" + memberId + "20010000";
    }
}
