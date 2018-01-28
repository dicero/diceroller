package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.ChannelEthBlockPORepository;
import com.dicero.diceroller.dal.mysql.repository.ChannelEthTransactionPORepository;
import com.dicero.diceroller.domain.model.ChannelEthBlockPO;
import com.dicero.diceroller.domain.model.ChannelEthTransactionPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 *
 * @author znz
 * @version 2018/1/28
 */
public class ChannelEthTransactionPORepositoryTest extends TestBase {
    @Autowired
    ChannelEthTransactionPORepository ChannelEthTransactionPORepository;

    @Test
    public void findByIdTest() {
        // ChannelEthTransactionPO record = ChannelEthTransactionPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        ChannelEthTransactionPO record = new ChannelEthTransactionPO();
        record.setHash("xxxxx");
        record.setNonce("12");
        record.setBlockHash("xxx");
        record.setBlockNumber("12");
        record.setTransactionIndex("1");
        record.setFromAddress("1");
        record.setToAddress("2");
        record.setAmountValue("12.00");
        record.setGas("12");
        record.setGasPrice("2432");
        record.setInput("xxxx");
        record.setUpdateTime(now);
        record.setCreateTime(now);
        record = ChannelEthTransactionPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }

}
