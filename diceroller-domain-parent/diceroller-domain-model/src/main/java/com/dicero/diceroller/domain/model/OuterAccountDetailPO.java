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
@Table(name = "t_dpm_outer_account_detail")
public class OuterAccountDetailPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String accountNo;
    private BigDecimal txnAmt;
    private String txnRemark;
    private String drcr;
    private String voucherNo;
    private String paymentSeqNo;
    private BigDecimal beforeAmt;
    private BigDecimal afterAmt;

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
    @Column(name = "txn_amt", nullable = false, precision = 8)
    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }

    @Basic
    @Column(name = "txn_remark", nullable = false, length = 200)
    public String getTxnRemark() {
        return txnRemark;
    }

    public void setTxnRemark(String txnRemark) {
        this.txnRemark = txnRemark;
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
    @Column(name = "voucher_no", nullable = false, length = 40)
    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
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
    @Column(name = "before_amt", nullable = false, precision = 8)
    public BigDecimal getBeforeAmt() {
        return beforeAmt;
    }

    public void setBeforeAmt(BigDecimal beforeAmt) {
        this.beforeAmt = beforeAmt;
    }

    @Basic
    @Column(name = "after_amt", nullable = false, precision = 8)
    public BigDecimal getAfterAmt() {
        return afterAmt;
    }

    public void setAfterAmt(BigDecimal afterAmt) {
        this.afterAmt = afterAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OuterAccountDetailPO that = (OuterAccountDetailPO) o;

        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (accountNo != null ? !accountNo.equals(that.accountNo) : that.accountNo != null) return false;
        if (txnAmt != null ? !txnAmt.equals(that.txnAmt) : that.txnAmt != null) return false;
        if (txnRemark != null ? !txnRemark.equals(that.txnRemark) : that.txnRemark != null) return false;
        if (drcr != null ? !drcr.equals(that.drcr) : that.drcr != null) return false;
        if (voucherNo != null ? !voucherNo.equals(that.voucherNo) : that.voucherNo != null) return false;
        if (paymentSeqNo != null ? !paymentSeqNo.equals(that.paymentSeqNo) : that.paymentSeqNo != null) return false;
        if (beforeAmt != null ? !beforeAmt.equals(that.beforeAmt) : that.beforeAmt != null) return false;
        if (afterAmt != null ? !afterAmt.equals(that.afterAmt) : that.afterAmt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (txnAmt != null ? txnAmt.hashCode() : 0);
        result = 31 * result + (txnRemark != null ? txnRemark.hashCode() : 0);
        result = 31 * result + (drcr != null ? drcr.hashCode() : 0);
        result = 31 * result + (voucherNo != null ? voucherNo.hashCode() : 0);
        result = 31 * result + (paymentSeqNo != null ? paymentSeqNo.hashCode() : 0);
        result = 31 * result + (beforeAmt != null ? beforeAmt.hashCode() : 0);
        result = 31 * result + (afterAmt != null ? afterAmt.hashCode() : 0);
        return result;
    }
}
