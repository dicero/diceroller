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
@Table(name = "tb_audit_log")
public class AuditLogPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int auditId;
    private String auditType;
    private String beginStatus;
    private String endStatus;
    private String operator;
    private String remark;

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
    @Column(name = "audit_id", nullable = false)
    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    @Basic
    @Column(name = "audit_type", nullable = false, length = 20)
    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    @Basic
    @Column(name = "begin_status", nullable = false, length = 20)
    public String getBeginStatus() {
        return beginStatus;
    }

    public void setBeginStatus(String beginStatus) {
        this.beginStatus = beginStatus;
    }

    @Basic
    @Column(name = "end_status", nullable = false, length = 20)
    public String getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(String endStatus) {
        this.endStatus = endStatus;
    }

    @Basic
    @Column(name = "operator", nullable = false, length = 20)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "remark", nullable = false, length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditLogPO that = (AuditLogPO) o;

        if (id != that.id) return false;
        if (auditId != that.auditId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (auditType != null ? !auditType.equals(that.auditType) : that.auditType != null) return false;
        if (beginStatus != null ? !beginStatus.equals(that.beginStatus) : that.beginStatus != null) return false;
        if (endStatus != null ? !endStatus.equals(that.endStatus) : that.endStatus != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + auditId;
        result = 31 * result + (auditType != null ? auditType.hashCode() : 0);
        result = 31 * result + (beginStatus != null ? beginStatus.hashCode() : 0);
        result = 31 * result + (endStatus != null ? endStatus.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
