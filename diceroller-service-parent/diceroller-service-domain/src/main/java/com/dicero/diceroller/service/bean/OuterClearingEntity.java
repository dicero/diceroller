package com.dicero.diceroller.service.bean;

import com.dicero.diceroller.domain.enums.PartyRoleEnums;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
public class OuterClearingEntity implements Serializable {
    private ClearAccount clearAccount;
    private PartyRoleEnums partyRoleEnums;
    private BigDecimal amt;
    private String paymentSeqNo;

    public OuterClearingEntity buildClearAccount(ClearAccount clearAccount){
        this.clearAccount = clearAccount;
        return this;
    }

    public OuterClearingEntity buildPartyRoleEnums(PartyRoleEnums partyRoleEnums){
        this.partyRoleEnums = partyRoleEnums;
        return this;
    }

    public OuterClearingEntity buildPaymentSeqNo(String paymentSeqNo){
        this.paymentSeqNo = paymentSeqNo;
        return this;
    }

    public OuterClearingEntity buildAmt(BigDecimal amt){
        this.amt = amt;
        return this;
    }

    public ClearAccount getClearAccount() {
        return clearAccount;
    }

    public void setClearAccount(ClearAccount clearAccount) {
        this.clearAccount = clearAccount;
    }

    public PartyRoleEnums getPartyRoleEnums() {
        return partyRoleEnums;
    }

    public void setPartyRoleEnums(PartyRoleEnums partyRoleEnums) {
        this.partyRoleEnums = partyRoleEnums;
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
