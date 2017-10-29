package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.TradeOrderPORepository;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class TradeOrderPORepositoryTest extends TestBase {
    @Autowired
    TradeOrderPORepository TradeOrderPORepository;

    @Test
    public void findByIdTest() {
        // TradeOrderPO record = TradeOrderPOrepository.findById(1);
        //  println(record);
        // Assert.assertNotNull(record);
    }
}
