package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;
import com.dicero.diceroller.domain.enums.SettlementStatusEnums;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
@Entity
@Table(name = "tb_settlement_order")
public class SettlementOrderPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String sessionId;
    private String paymentSeqNo;
    private String clearingCodeList;
    private SettlementStatusEnums status;

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
    @Column(name = "session_id", nullable = false, length = 40)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "payment_seq_no", nullable = false, length = 27)
    public String getPaymentSeqNo() {
        return paymentSeqNo;
    }

    public void setPaymentSeqNo(String paymentSeqNo) {
        this.paymentSeqNo = paymentSeqNo;
    }

    @Basic
    @Column(name = "clearing_code_list", nullable = false, length = 200)
    public String getClearingCodeList() {
        return clearingCodeList;
    }

    public void setClearingCodeList(String clearingCodeList) {
        this.clearingCodeList = clearingCodeList;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    public SettlementStatusEnums getStatus() {
        return status;
    }

    public void setStatus(SettlementStatusEnums status) {
        this.status = status;
    }
}
