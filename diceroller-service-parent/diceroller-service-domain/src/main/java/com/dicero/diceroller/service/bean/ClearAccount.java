package com.dicero.diceroller.service.bean;

import com.dicero.diceroller.domain.enums.InnerAccountEnums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public class ClearAccount {
    private String accountNo;


    public ClearAccount(InnerAccountEnums innerAccountEnums) {
        this.accountNo = innerAccountEnums.getAccountNo();
    }

    public ClearAccount(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "ClearAccount{" +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
