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
@Table(name = "t_tss_trade_order")
public class TradeOrderPO extends BasePO {
    private int id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String tradeVoucherNo;
    private String tradeSrcVoucherNo;
    private BigDecimal tradeAmount;
    private int buyerId;
    private String buyerName;
    private int sellerId;
    private String sellerName;
    private String buyerAccountNo;
    private String sellerAccountNo;
    private String remark;
    private String status;

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
    @Column(name = "trade_voucher_no", nullable = false, length = 40)
    public String getTradeVoucherNo() {
        return tradeVoucherNo;
    }

    public void setTradeVoucherNo(String tradeVoucherNo) {
        this.tradeVoucherNo = tradeVoucherNo;
    }

    @Basic
    @Column(name = "trade_src_voucher_no", nullable = false, length = 40)
    public String getTradeSrcVoucherNo() {
        return tradeSrcVoucherNo;
    }

    public void setTradeSrcVoucherNo(String tradeSrcVoucherNo) {
        this.tradeSrcVoucherNo = tradeSrcVoucherNo;
    }

    @Basic
    @Column(name = "trade_amount", nullable = false, precision = 8)
    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    @Basic
    @Column(name = "buyer_id", nullable = false)
    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column(name = "buyer_name", nullable = false, length = 20)
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Basic
    @Column(name = "seller_id", nullable = false)
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "seller_name", nullable = false, length = 20)
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Basic
    @Column(name = "buyer_account_no", nullable = false, length = 27)
    public String getBuyerAccountNo() {
        return buyerAccountNo;
    }

    public void setBuyerAccountNo(String buyerAccountNo) {
        this.buyerAccountNo = buyerAccountNo;
    }

    @Basic
    @Column(name = "seller_account_no", nullable = false, length = 27)
    public String getSellerAccountNo() {
        return sellerAccountNo;
    }

    public void setSellerAccountNo(String sellerAccountNo) {
        this.sellerAccountNo = sellerAccountNo;
    }

    @Basic
    @Column(name = "remark", nullable = false, length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeOrderPO that = (TradeOrderPO) o;

        if (id != that.id) return false;
        if (buyerId != that.buyerId) return false;
        if (sellerId != that.sellerId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (tradeVoucherNo != null ? !tradeVoucherNo.equals(that.tradeVoucherNo) : that.tradeVoucherNo != null)
            return false;
        if (tradeSrcVoucherNo != null ? !tradeSrcVoucherNo.equals(that.tradeSrcVoucherNo) : that.tradeSrcVoucherNo != null)
            return false;
        if (tradeAmount != null ? !tradeAmount.equals(that.tradeAmount) : that.tradeAmount != null) return false;
        if (buyerName != null ? !buyerName.equals(that.buyerName) : that.buyerName != null) return false;
        if (sellerName != null ? !sellerName.equals(that.sellerName) : that.sellerName != null) return false;
        if (buyerAccountNo != null ? !buyerAccountNo.equals(that.buyerAccountNo) : that.buyerAccountNo != null)
            return false;
        if (sellerAccountNo != null ? !sellerAccountNo.equals(that.sellerAccountNo) : that.sellerAccountNo != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (tradeVoucherNo != null ? tradeVoucherNo.hashCode() : 0);
        result = 31 * result + (tradeSrcVoucherNo != null ? tradeSrcVoucherNo.hashCode() : 0);
        result = 31 * result + (tradeAmount != null ? tradeAmount.hashCode() : 0);
        result = 31 * result + buyerId;
        result = 31 * result + (buyerName != null ? buyerName.hashCode() : 0);
        result = 31 * result + sellerId;
        result = 31 * result + (sellerName != null ? sellerName.hashCode() : 0);
        result = 31 * result + (buyerAccountNo != null ? buyerAccountNo.hashCode() : 0);
        result = 31 * result + (sellerAccountNo != null ? sellerAccountNo.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
