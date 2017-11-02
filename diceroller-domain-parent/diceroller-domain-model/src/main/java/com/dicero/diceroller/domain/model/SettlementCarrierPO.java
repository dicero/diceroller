package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
@Entity
@Table(name = "tb_settlement_carrier")
public class SettlementCarrierPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String requestNo;
    private String paymentSeqNo;
    private String status;
    private String summary;
    private String paymentType;
    private String settlementType;

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
    @Column(name = "request_no", nullable = false, length = 40)
    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
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
    @Column(name = "status", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "summary", nullable = true, length = 200)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "payment_type", nullable = false, length = 20)
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "settlement_type", nullable = false, length = 20)
    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettlementCarrierPO that = (SettlementCarrierPO) o;

        if (id != that.id) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (requestNo != null ? !requestNo.equals(that.requestNo) : that.requestNo != null) return false;
        if (paymentSeqNo != null ? !paymentSeqNo.equals(that.paymentSeqNo) : that.paymentSeqNo != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (paymentType != null ? !paymentType.equals(that.paymentType) : that.paymentType != null) return false;
        if (settlementType != null ? !settlementType.equals(that.settlementType) : that.settlementType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (requestNo != null ? requestNo.hashCode() : 0);
        result = 31 * result + (paymentSeqNo != null ? paymentSeqNo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (settlementType != null ? settlementType.hashCode() : 0);
        return result;
    }
}
