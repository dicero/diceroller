package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.OuterAccountPORepository;
import com.dicero.diceroller.domain.model.OuterAccountPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class OuterAccountRepositoryTest  extends TestBase {
    @Autowired OuterAccountPORepository OuterAccountPORepository;

    @Test
    public void saveTest(){
        OuterAccountPO record = new OuterAccountPO();
        record.setAccountNo("100");
        record.setAccountName("清掉");
        record.setAccountTitleNo("10001");
        record.setMemberId(1000);
        record.setStatusMap("1");
        record.setAccountType("201");
        record.setCreateTime(now);
        record.setUpdateTime(now);

        record = OuterAccountPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }

    @Test
    public void findByIdTest(){
        OuterAccountPO outerAccountPO = OuterAccountPORepository.findById(1);
        println(outerAccountPO);
        Assert.assertNotNull(outerAccountPO);
    }
}
