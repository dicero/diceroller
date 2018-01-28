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
@Table(name = "t_channel_eth_block")
public class ChannelEthBlockPO extends BasePO {
    private int id;
    private String number;
    private String hash;
    private String parentHash;
    private String nonce;
    private String sha3Uncles;
    private String logsBloom;
    private String transactionsRoot;
    private String stateRoot;
    private String author;
    private String miner;
    private String mixHash;
    private String difficulty;
    private String totalDifficulty;
    private String extraData;
    private String size;
    private String gasLimit;
    private String gasUsed;
    private String transactions;
    private String uncles;
    private String sealFields;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 45)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
    @Column(name = "parent_hash", nullable = false, length = 45)
    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
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
    @Column(name = "sha3_uncles", nullable = true, length = 45)
    public String getSha3Uncles() {
        return sha3Uncles;
    }

    public void setSha3Uncles(String sha3Uncles) {
        this.sha3Uncles = sha3Uncles;
    }

    @Basic
    @Column(name = "logs_bloom", nullable = true, length = 45)
    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    @Basic
    @Column(name = "transactions_root", nullable = true, length = 45)
    public String getTransactionsRoot() {
        return transactionsRoot;
    }

    public void setTransactionsRoot(String transactionsRoot) {
        this.transactionsRoot = transactionsRoot;
    }

    @Basic
    @Column(name = "state_root", nullable = true, length = 45)
    public String getStateRoot() {
        return stateRoot;
    }

    public void setStateRoot(String stateRoot) {
        this.stateRoot = stateRoot;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 45)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "miner", nullable = true, length = 45)
    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    @Basic
    @Column(name = "mix_hash", nullable = true, length = 45)
    public String getMixHash() {
        return mixHash;
    }

    public void setMixHash(String mixHash) {
        this.mixHash = mixHash;
    }

    @Basic
    @Column(name = "difficulty", nullable = true, length = 45)
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Basic
    @Column(name = "total_difficulty", nullable = true, length = 45)
    public String getTotalDifficulty() {
        return totalDifficulty;
    }

    public void setTotalDifficulty(String totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }

    @Basic
    @Column(name = "extra_data", nullable = true, length = 45)
    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    @Basic
    @Column(name = "size", nullable = true, length = 45)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "gas_limit", nullable = true, length = 45)
    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    @Basic
    @Column(name = "gas_used", nullable = true, length = 45)
    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    @Basic
    @Column(name = "transactions", nullable = true, length = -1, columnDefinition = "TEXT")
    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    @Basic
    @Column(name = "uncles", nullable = true, length = -1, columnDefinition = "TEXT")
    public String getUncles() {
        return uncles;
    }

    public void setUncles(String uncles) {
        this.uncles = uncles;
    }

    @Basic
    @Column(name = "seal_fields", nullable = true, length = -1, columnDefinition = "TEXT")
    public String getSealFields() {
        return sealFields;
    }

    public void setSealFields(String sealFields) {
        this.sealFields = sealFields;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelEthBlockPO that = (ChannelEthBlockPO) o;

        if (id != that.id) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        if (parentHash != null ? !parentHash.equals(that.parentHash) : that.parentHash != null) return false;
        if (nonce != null ? !nonce.equals(that.nonce) : that.nonce != null) return false;
        if (sha3Uncles != null ? !sha3Uncles.equals(that.sha3Uncles) : that.sha3Uncles != null) return false;
        if (logsBloom != null ? !logsBloom.equals(that.logsBloom) : that.logsBloom != null) return false;
        if (transactionsRoot != null ? !transactionsRoot.equals(that.transactionsRoot) : that.transactionsRoot != null)
            return false;
        if (stateRoot != null ? !stateRoot.equals(that.stateRoot) : that.stateRoot != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (miner != null ? !miner.equals(that.miner) : that.miner != null) return false;
        if (mixHash != null ? !mixHash.equals(that.mixHash) : that.mixHash != null) return false;
        if (difficulty != null ? !difficulty.equals(that.difficulty) : that.difficulty != null) return false;
        if (totalDifficulty != null ? !totalDifficulty.equals(that.totalDifficulty) : that.totalDifficulty != null)
            return false;
        if (extraData != null ? !extraData.equals(that.extraData) : that.extraData != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (gasLimit != null ? !gasLimit.equals(that.gasLimit) : that.gasLimit != null) return false;
        if (gasUsed != null ? !gasUsed.equals(that.gasUsed) : that.gasUsed != null) return false;
        if (transactions != null ? !transactions.equals(that.transactions) : that.transactions != null) return false;
        if (uncles != null ? !uncles.equals(that.uncles) : that.uncles != null) return false;
        if (sealFields != null ? !sealFields.equals(that.sealFields) : that.sealFields != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (parentHash != null ? parentHash.hashCode() : 0);
        result = 31 * result + (nonce != null ? nonce.hashCode() : 0);
        result = 31 * result + (sha3Uncles != null ? sha3Uncles.hashCode() : 0);
        result = 31 * result + (logsBloom != null ? logsBloom.hashCode() : 0);
        result = 31 * result + (transactionsRoot != null ? transactionsRoot.hashCode() : 0);
        result = 31 * result + (stateRoot != null ? stateRoot.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (miner != null ? miner.hashCode() : 0);
        result = 31 * result + (mixHash != null ? mixHash.hashCode() : 0);
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (totalDifficulty != null ? totalDifficulty.hashCode() : 0);
        result = 31 * result + (extraData != null ? extraData.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (gasLimit != null ? gasLimit.hashCode() : 0);
        result = 31 * result + (gasUsed != null ? gasUsed.hashCode() : 0);
        result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
        result = 31 * result + (uncles != null ? uncles.hashCode() : 0);
        result = 31 * result + (sealFields != null ? sealFields.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
