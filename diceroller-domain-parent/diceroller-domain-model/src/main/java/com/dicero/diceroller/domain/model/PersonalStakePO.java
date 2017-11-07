package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;
import com.dicero.diceroller.domain.enums.FundTypeEnums;

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
@Table(name = "tr_personal_stake")
public class PersonalStakePO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int memberId;
    private FundTypeEnums fundType;
    private BigDecimal amt;
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
    @Column(name = "fund_type", nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    public FundTypeEnums getFundType() {
        return fundType;
    }

    public void setFundType(FundTypeEnums fundType) {
        this.fundType = fundType;
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
    @Column(name = "stake_id", nullable = false, length = 40)
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

        PersonalStakePO that = (PersonalStakePO) o;

        if (id != that.id) return false;
        if (memberId != that.memberId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (fundType != null ? !fundType.equals(that.fundType) : that.fundType != null) return false;
        if (amt != null ? !amt.equals(that.amt) : that.amt != null) return false;
        if (stakeId != null ? !stakeId.equals(that.stakeId) : that.stakeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + (fundType != null ? fundType.hashCode() : 0);
        result = 31 * result + (amt != null ? amt.hashCode() : 0);
        result = 31 * result + (stakeId != null ? stakeId.hashCode() : 0);
        return result;
    }
}
