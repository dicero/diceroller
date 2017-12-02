package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;
import com.dicero.diceroller.domain.enums.EffectiveEnums;
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
    private BigDecimal changeAmt;
    private BigDecimal amt;
    private String stakeId;
    private EffectiveEnums effective;
    private BigDecimal target;
    private int targetCondition;
    private BigDecimal payout;
    private int nonce;
    private String username;
    private double randomResult;

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
    @Column(name = "change_amt", nullable = false, precision = 8)
    public BigDecimal getChangeAmt() {
        return changeAmt;
    }

    public void setChangeAmt(BigDecimal changeAmt) {
        this.changeAmt = changeAmt;
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

    @Basic
    @Column(name = "effective", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    public EffectiveEnums getEffective() {
        return effective;
    }

    public void setEffective(EffectiveEnums effective) {
        this.effective = effective;
    }

    @Basic
    @Column(name = "target", nullable = false, precision = 4)
    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    @Basic
    @Column(name = "target_condition", nullable = false)
    public int getTargetCondition() {
        return targetCondition;
    }

    public void setTargetCondition(int targetCondition) {
        this.targetCondition = targetCondition;
    }

    @Basic
    @Column(name = "nonce", nullable = false)
    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    @Basic
    @Column(name = "payout", precision = 2)
    public BigDecimal getPayout() {
        return payout;
    }

    public void setPayout(BigDecimal payout) {
        this.payout = payout;
    }

    @Basic
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "random_result" )
    public double getRandomResult() {
        return randomResult;
    }

    public void setRandomResult(double randomResult) {
        this.randomResult = randomResult;
    }
}
