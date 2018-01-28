package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.ChannelEthBlockPORepository;
import com.dicero.diceroller.domain.model.ChannelEthBlockPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * <p></p>
 *
 * @author znz
 * @version 2018/1/28
 */
public class ChannelEthBlockPORepositoryTest extends TestBase {
    @Autowired
    ChannelEthBlockPORepository ChannelEthBlockPORepository;

    @Test
    public void findByIdTest() {
        // ChannelEthBlockPO record = ChannelEthBlockPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        ChannelEthBlockPO record = new ChannelEthBlockPO();
        record.setNumber("1");
        record.setHash("xxxxx");
        record.setParentHash("xxxxxx");
        record.setNonce("12");
        record.setSha3Uncles("sssss");
        record.setLogsBloom("");
        record.setTransactionsRoot("");
        record.setUpdateTime(now);
        record.setCreateTime(now);
        record = ChannelEthBlockPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }
}
