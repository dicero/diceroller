package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz
 * @version 2018/1/28
 */
@Entity
@Table(name = "t_channel_eth_transaction")
public class ChannelEthTransactionPO extends BasePO {
    private int id;
    private String hash;
    private String nonce;
    private String blockHash;
    private String blockNumber;
    private String transactionIndex;
    private String fromAddress;
    private String toAddress;
    private String amountValue;
    private String gasPrice;
    private String gas;
    private String input;
    private String creates;
    private String publicKey;
    private String raw;
    private String r;
    private String s;
    private Integer v;
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
    @Column(name = "hash", nullable = false, length = 45)
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Basic
    @Column(name = "nonce", nullable = false, length = 45)
    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Basic
    @Column(name = "block_hash", nullable = false, length = 45)
    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    @Basic
    @Column(name = "block_number", nullable = false, length = 45)
    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    @Basic
    @Column(name = "transaction_index", nullable = false, length = 45)
    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    @Basic
    @Column(name = "from_address", nullable = false, length = 45)
    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }


    @Basic
    @Column(name = "to_address", nullable = false, length = 45)
    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    @Basic
    @Column(name = "amount_value", nullable = false, length = 45)
    public String getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(String amountValue) {
        this.amountValue = amountValue;
    }


    @Basic
    @Column(name = "gas_price", nullable = false, length = 45)
    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Basic
    @Column(name = "gas", nullable = false, length = 45)
    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    @Basic
    @Column(name = "input", nullable = false, length = 45)
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Basic
    @Column(name = "creates", nullable = true, length = 45)
    public String getCreates() {
        return creates;
    }

    public void setCreates(String creates) {
        this.creates = creates;
    }

    @Basic
    @Column(name = "public_key", nullable = true, length = 45)
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Basic
    @Column(name = "raw", nullable = true, length = 45)
    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Basic
    @Column(name = "r", nullable = true, length = 45)
    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    @Basic
    @Column(name = "s", nullable = true, length = 45)
    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Basic
    @Column(name = "v", nullable = true)
    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
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
