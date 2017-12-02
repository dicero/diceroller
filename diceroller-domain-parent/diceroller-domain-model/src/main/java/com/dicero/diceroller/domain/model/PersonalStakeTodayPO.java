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
@Table(name = "tr_personal_stake_today")
public class PersonalStakeTodayPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int memberId;
    private BigDecimal allStakeAmt;
    private BigDecimal allWinAmt;
    private BigDecimal allLoseAmt;
    private int allWinGames;
    private int allLoseGames;
    private BigDecimal winningPos;
    private String calDate;

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
    @Column(name = "all_stake_amt", nullable = false, precision = 8)
    public BigDecimal getAllStakeAmt() {
        return allStakeAmt;
    }

    public void setAllStakeAmt(BigDecimal allStakeAmt) {
        this.allStakeAmt = allStakeAmt;
    }

    @Basic
    @Column(name = "all_win_amt", nullable = false, precision = 8)
    public BigDecimal getAllWinAmt() {
        return allWinAmt;
    }

    public void setAllWinAmt(BigDecimal allWinAmt) {
        this.allWinAmt = allWinAmt;
    }

    @Basic
    @Column(name = "all_lose_amt", nullable = false, precision = 8)
    public BigDecimal getAllLoseAmt() {
        return allLoseAmt;
    }

    public void setAllLoseAmt(BigDecimal allLoseAmt) {
        this.allLoseAmt = allLoseAmt;
    }

    @Basic
    @Column(name = "all_win_games", nullable = false)
    public int getAllWinGames() {
        return allWinGames;
    }

    public void setAllWinGames(int allWinGames) {
        this.allWinGames = allWinGames;
    }

    @Basic
    @Column(name = "all_lose_games", nullable = false)
    public int getAllLoseGames() {
        return allLoseGames;
    }

    public void setAllLoseGames(int allLoseGames) {
        this.allLoseGames = allLoseGames;
    }

    @Basic
    @Column(name = "winning_pos", nullable = false, precision = 2)
    public BigDecimal getWinningPos() {
        return winningPos;
    }

    public void setWinningPos(BigDecimal winningPos) {
        this.winningPos = winningPos;
    }

    @Basic
    @Column(name = "cal_date", nullable = false, length = 8)
    public String getCalDate() {
        return calDate;
    }

    public void setCalDate(String calDate) {
        this.calDate = calDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalStakeTodayPO that = (PersonalStakeTodayPO) o;

        if (id != that.id) return false;
        if (memberId != that.memberId) return false;
        if (allWinGames != that.allWinGames) return false;
        if (allLoseGames != that.allLoseGames) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (allStakeAmt != null ? !allStakeAmt.equals(that.allStakeAmt) : that.allStakeAmt != null) return false;
        if (allWinAmt != null ? !allWinAmt.equals(that.allWinAmt) : that.allWinAmt != null) return false;
        if (allLoseAmt != null ? !allLoseAmt.equals(that.allLoseAmt) : that.allLoseAmt != null) return false;
        if (winningPos != null ? !winningPos.equals(that.winningPos) : that.winningPos != null) return false;
        if (calDate != null ? !calDate.equals(that.calDate) : that.calDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + (allStakeAmt != null ? allStakeAmt.hashCode() : 0);
        result = 31 * result + (allWinAmt != null ? allWinAmt.hashCode() : 0);
        result = 31 * result + (allLoseAmt != null ? allLoseAmt.hashCode() : 0);
        result = 31 * result + allWinGames;
        result = 31 * result + allLoseGames;
        result = 31 * result + (winningPos != null ? winningPos.hashCode() : 0);
        result = 31 * result + (calDate != null ? calDate.hashCode() : 0);
        return result;
    }
}
