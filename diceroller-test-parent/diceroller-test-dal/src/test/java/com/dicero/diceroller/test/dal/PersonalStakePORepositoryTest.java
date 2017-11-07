package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakePORepository;
import com.dicero.diceroller.domain.enums.FundTypeEnums;
import com.dicero.diceroller.domain.model.PersonalStakePO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalStakePORepositoryTest extends TestBase {
    @Autowired
    PersonalStakePORepository PersonalStakePORepository;

    @Test
    public void findByIdTest() {
        // PersonalStakePO record = PersonalStakePOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        PersonalStakePO record = new PersonalStakePO();
        record.setMemberId(testMemberId);
        record.setFundType(FundTypeEnums.FO);
        record.setAmt(BigDecimal.TEN);
        record.setStakeId(RandomUtil.randomStake());
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalStakePORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }
}
