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
@Table(name = "tr_personal_bill")
public class PersonalBillPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int memberId;
    private String tradeType;
    private String seqNo;
    private String tradeStatus;
    private BigDecimal tradeAmt;
    private String tradeTitle;
    private String tradeInfo;
    private String bitAddress;
    private String stakeId;

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
    @Column(name = "member_id", nullable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "trade_type", nullable = false, length = 2)
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @Basic
    @Column(name = "seq_no", nullable = false, length = 40)
    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    @Basic
    @Column(name = "trade_status", nullable = false, length = 2)
    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    @Basic
    @Column(name = "trade_amt", nullable = false, precision = 8)
    public BigDecimal getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(BigDecimal tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    @Basic
    @Column(name = "trade_title", nullable = false, length = 20)
    public String getTradeTitle() {
        return tradeTitle;
    }

    public void setTradeTitle(String tradeTitle) {
        this.tradeTitle = tradeTitle;
    }

    @Basic
    @Column(name = "trade_info", nullable = true, length = 40)
    public String getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(String tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

    @Basic
    @Column(name = "bit_address", nullable = true, length = 40)
    public String getBitAddress() {
        return bitAddress;
    }

    public void setBitAddress(String bitAddress) {
        this.bitAddress = bitAddress;
    }

    @Basic
    @Column(name = "stake_id", nullable = true, length = 40)
    public String getStakeId() {
        return stakeId;
    }

    public void setStakeId(String stakeId) {
        this.stakeId = stakeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalBillPO that = (PersonalBillPO) o;

        if (id != that.id) return false;
        if (memberId != that.memberId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (tradeType != null ? !tradeType.equals(that.tradeType) : that.tradeType != null) return false;
        if (seqNo != null ? !seqNo.equals(that.seqNo) : that.seqNo != null) return false;
        if (tradeStatus != null ? !tradeStatus.equals(that.tradeStatus) : that.tradeStatus != null) return false;
        if (tradeAmt != null ? !tradeAmt.equals(that.tradeAmt) : that.tradeAmt != null) return false;
        if (tradeTitle != null ? !tradeTitle.equals(that.tradeTitle) : that.tradeTitle != null) return false;
        if (tradeInfo != null ? !tradeInfo.equals(that.tradeInfo) : that.tradeInfo != null) return false;
        if (bitAddress != null ? !bitAddress.equals(that.bitAddress) : that.bitAddress != null) return false;
        if (stakeId != null ? !stakeId.equals(that.stakeId) : that.stakeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + (tradeType != null ? tradeType.hashCode() : 0);
        result = 31 * result + (seqNo != null ? seqNo.hashCode() : 0);
        result = 31 * result + (tradeStatus != null ? tradeStatus.hashCode() : 0);
        result = 31 * result + (tradeAmt != null ? tradeAmt.hashCode() : 0);
        result = 31 * result + (tradeTitle != null ? tradeTitle.hashCode() : 0);
        result = 31 * result + (tradeInfo != null ? tradeInfo.hashCode() : 0);
        result = 31 * result + (bitAddress != null ? bitAddress.hashCode() : 0);
        result = 31 * result + (stakeId != null ? stakeId.hashCode() : 0);
        return result;
    }
}
