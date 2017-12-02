package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/20
 */
@Entity
@Table(name = "t_dpm_eth_address")
public class EthAddressPO extends BasePO{
    private int id;

    private String address;
    private String xpub;
    private String xpri;
    private Integer hasUse;

    private Timestamp createTime;
    private Timestamp updateTime;

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
    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "x_pub", nullable = false)
    public String getXpub() {
        return xpub;
    }

    public void setXpub(String xpub) {
        this.xpub = xpub;
    }

    @Basic
    @Column(name = "x_pri", nullable = false)
    public String getXpri() {
        return xpri;
    }


    public void setXpri(String xpri) {
        this.xpri = xpri;
    }


    @Basic
    @Column(name = "has_use", nullable = false)
    public Integer getHasUse() {
        return hasUse;
    }

    public void setHasUse(Integer hasUse) {
        this.hasUse = hasUse;
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
}
