package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;
import com.dicero.diceroller.domain.enums.DRCREnums;

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
@Table(name = "t_dpm_inner_account")
public class InnerAccountPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String accountNo;
    private String accountTitleNo;
    private String accountName;
    private DRCREnums drcr;
    private BigDecimal balance;

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
    @Column(name = "account_no", nullable = false, length = 27)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "account_title_no", nullable = false, length = 30)
    public String getAccountTitleNo() {
        return accountTitleNo;
    }

    public void setAccountTitleNo(String accountTitleNo) {
        this.accountTitleNo = accountTitleNo;
    }

    @Basic
    @Column(name = "account_name", nullable = false, length = 20)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "drcr", nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    public DRCREnums getDrcr() {
        return drcr;
    }

    public void setDrcr(DRCREnums drcr) {
        this.drcr = drcr;
    }

    @Basic
    @Column(name = "balance", nullable = false, precision = 8)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InnerAccountPO that = (InnerAccountPO) o;

        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (accountNo != null ? !accountNo.equals(that.accountNo) : that.accountNo != null) return false;
        if (accountTitleNo != null ? !accountTitleNo.equals(that.accountTitleNo) : that.accountTitleNo != null)
            return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (drcr != null ? !drcr.equals(that.drcr) : that.drcr != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (accountTitleNo != null ? accountTitleNo.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (drcr != null ? drcr.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}
