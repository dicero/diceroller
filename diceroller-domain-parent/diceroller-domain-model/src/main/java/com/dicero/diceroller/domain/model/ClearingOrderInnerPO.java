package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
@Entity
@Table(name = "tb_clearing_order_inner")
public class ClearingOrderInnerPO extends BasePO {
    private Integer id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String sessionId;
    private String paymentSeqNo;
    private String clearingCode;
    private String partyRole;
    private String partyId;
    private String accountNo;
    private String drcr;
    private BigDecimal amt;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "session_id", nullable = false, length = 40)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "payment_seq_no", nullable = false, length = 40)
    public String getPaymentSeqNo() {
        return paymentSeqNo;
    }

    public void setPaymentSeqNo(String paymentSeqNo) {
        this.paymentSeqNo = paymentSeqNo;
    }

    @Basic
    @Column(name = "clearing_code", nullable = false, length = 20)
    public String getClearingCode() {
        return clearingCode;
    }

    public void setClearingCode(String clearingCode) {
        this.clearingCode = clearingCode;
    }

    @Basic
    @Column(name = "party_role", nullable = false, length = 20)
    public String getPartyRole() {
        return partyRole;
    }

    public void setPartyRole(String partyRole) {
        this.partyRole = partyRole;
    }

    @Basic
    @Column(name = "party_id", nullable = false, length = 20)
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    @Basic
    @Column(name = "account_no", nullable = false, length = 27)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "drcr", nullable = false, length = 2)
    public String getDrcr() {
        return drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    @Basic
    @Column(name = "amt", nullable = false, precision = 8)
    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

}
