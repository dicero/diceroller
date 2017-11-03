package com.dicero.diceroller.service.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
public class InnerClearingEntity implements Serializable {
    private ClearAccount drClearAccount;
    private ClearAccount crClearAccount;
    private BigDecimal amt;
    private String paymentSeqNo;


    public InnerClearingEntity buildDrClearAccount(ClearAccount drClearAccount) {
        this.drClearAccount = drClearAccount;
        return this;
    }
    public InnerClearingEntity buildCrClearAccount(ClearAccount crClearAccount) {
        this.crClearAccount = crClearAccount;
        return this;
    }

    public InnerClearingEntity buildAmt(BigDecimal amt) {
        this.amt = amt;
        return this;
    }

    public InnerClearingEntity buildPaymentSeqNo(String paymentSeqNo) {
        this.paymentSeqNo = paymentSeqNo;
        return this;
    }

    public ClearAccount getDrClearAccount() {
        return drClearAccount;
    }

    public void setDrClearAccount(ClearAccount drClearAccount) {
        this.drClearAccount = drClearAccount;
    }

    public ClearAccount getCrClearAccount() {
        return crClearAccount;
    }

    public void setCrClearAccount(ClearAccount crClearAccount) {
        this.crClearAccount = crClearAccount;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getPaymentSeqNo() {
        return paymentSeqNo;
    }

    public void setPaymentSeqNo(String paymentSeqNo) {
        this.paymentSeqNo = paymentSeqNo;
    }

}
