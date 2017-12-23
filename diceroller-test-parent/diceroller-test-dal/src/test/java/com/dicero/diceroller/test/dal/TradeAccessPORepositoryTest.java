package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.domain.enums.AccessNodeEnums;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.TradeAccessPORepository;
import com.dicero.diceroller.domain.model.TradeAccessPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/23
 */
public class TradeAccessPORepositoryTest extends TestBase {
    @Autowired
    TradeAccessPORepository TradeAccessPORepository;

    @Test
    public void findByIdTest() {
        // TradeAccessPO record = TradeAccessPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        TradeAccessPO record = new TradeAccessPO();
        record.setMemberId(100000);
        record.setNode(AccessNodeEnums.PASS);
        record.setVersion(1);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = TradeAccessPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }

    @Test
    public void updateNodeByIdTest() {
        TradeAccessPO record_1 = TradeAccessPORepository.findByMemberIdAndNode(100000, AccessNodeEnums.PASS);
        record_1.setVersion(record_1.getVersion() + 1);
        TradeAccessPO record_2 = TradeAccessPORepository.findByMemberIdAndNode(100000, AccessNodeEnums.PASS);
        record_2.setVersion(record_2.getVersion() + 1);

        try {
            System.out.println("1:--" + record_1.getVersion());
            int rows = TradeAccessPORepository.updateNodeById(record_1.getId(), record_1.getVersion(), AccessNodeEnums.WAIT);
            System.out.println("1:--" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("2:--" + record_2.getVersion());
            int rows = TradeAccessPORepository.updateNodeById(record_2.getId(), record_2.getVersion(), AccessNodeEnums.WAIT);
            System.out.println("2:--" + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-- end");
        println(record_1);
        Assert.assertNotNull(record_1);
    }
}
