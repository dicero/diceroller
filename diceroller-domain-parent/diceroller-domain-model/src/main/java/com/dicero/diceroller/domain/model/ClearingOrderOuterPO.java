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
@Table(name = "tb_clearing_order_outer")
public class ClearingOrderOuterPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String sessionId;
    private String partyRole;
    private String partyId;
    private String accountNo;
    private BigDecimal amt;
    private String clearingCode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "amt", nullable = false, precision = 8)
    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    @Basic
    @Column(name = "clearing_code", nullable = false, length = 20)
    public String getClearingCode() {
        return clearingCode;
    }

    public void setClearingCode(String clearingCode) {
        this.clearingCode = clearingCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClearingOrderOuterPO that = (ClearingOrderOuterPO) o;

        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (partyRole != null ? !partyRole.equals(that.partyRole) : that.partyRole != null) return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (accountNo != null ? !accountNo.equals(that.accountNo) : that.accountNo != null) return false;
        if (amt != null ? !amt.equals(that.amt) : that.amt != null) return false;
        if (clearingCode != null ? !clearingCode.equals(that.clearingCode) : that.clearingCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (partyRole != null ? partyRole.hashCode() : 0);
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (amt != null ? amt.hashCode() : 0);
        result = 31 * result + (clearingCode != null ? clearingCode.hashCode() : 0);
        return result;
    }
}
