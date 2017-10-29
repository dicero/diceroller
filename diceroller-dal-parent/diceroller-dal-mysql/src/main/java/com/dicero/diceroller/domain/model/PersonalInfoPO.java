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
@Table(name = "tr_personal_info")
public class PersonalInfoPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int memberId;
    private String notifyEmail;
    private String notifyPhone;
    private String notifyBitAddress;

    @Id
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
    @Column(name = "notify_email", nullable = true, length = 20)
    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    @Basic
    @Column(name = "notify_phone", nullable = true, length = 20)
    public String getNotifyPhone() {
        return notifyPhone;
    }

    public void setNotifyPhone(String notifyPhone) {
        this.notifyPhone = notifyPhone;
    }

    @Basic
    @Column(name = "notify_bit_address", nullable = true, length = 40)
    public String getNotifyBitAddress() {
        return notifyBitAddress;
    }

    public void setNotifyBitAddress(String notifyBitAddress) {
        this.notifyBitAddress = notifyBitAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalInfoPO that = (PersonalInfoPO) o;

        if (id != that.id) return false;
        if (memberId != that.memberId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (notifyEmail != null ? !notifyEmail.equals(that.notifyEmail) : that.notifyEmail != null) return false;
        if (notifyPhone != null ? !notifyPhone.equals(that.notifyPhone) : that.notifyPhone != null) return false;
        if (notifyBitAddress != null ? !notifyBitAddress.equals(that.notifyBitAddress) : that.notifyBitAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + (notifyEmail != null ? notifyEmail.hashCode() : 0);
        result = 31 * result + (notifyPhone != null ? notifyPhone.hashCode() : 0);
        result = 31 * result + (notifyBitAddress != null ? notifyBitAddress.hashCode() : 0);
        return result;
    }
}
