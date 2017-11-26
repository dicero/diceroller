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
@Table(name = "tr_personal_seed_tmp")
public class PersonalSeedTmpPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int memberId;
    private String serverSeed;
    private String clientSeed;
    private int defaultOver;

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
    @Column(name = "server_seed", nullable = false, length = 64)
    public String getServerSeed() {
        return serverSeed;
    }

    public void setServerSeed(String serverSeed) {
        this.serverSeed = serverSeed;
    }

    @Basic
    @Column(name = "client_seed", nullable = false, length = 64)
    public String getClientSeed() {
        return clientSeed;
    }

    public void setClientSeed(String clientSeed) {
        this.clientSeed = clientSeed;
    }

    @Basic
    @Column(name = "default_over", nullable = false)
    public int getDefaultOver() {
        return defaultOver;
    }

    public void setDefaultOver(int defaultOver) {
        this.defaultOver = defaultOver;
    }
}
