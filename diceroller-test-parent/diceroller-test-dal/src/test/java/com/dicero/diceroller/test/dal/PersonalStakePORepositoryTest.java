package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakePORepository;
import com.dicero.diceroller.domain.enums.EffectiveEnums;
import com.dicero.diceroller.domain.enums.FundTypeEnums;
import com.dicero.diceroller.domain.model.PersonalStakePO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

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
    public void findAllByMemberIdAndEffectiveTest() {
        List<PersonalStakePO> personalStakePOList = PersonalStakePORepository.findAllByMemberIdAndEffective(2000000029, EffectiveEnums.TRUE,
                new PageRequest(0, 10, new Sort(Sort.Direction.DESC, new String[]{"createTime"})));
         println(personalStakePOList);
         Assert.assertNotNull(personalStakePOList);
    }

    @Test
    public void saveTest() {
        PersonalStakePO record = new PersonalStakePO();
        record.setMemberId(testMemberId);
        record.setFundType(FundTypeEnums.FO);
        record.setAmt(BigDecimal.TEN);
        record.setStakeId(RandomUtil.randomStake());
        record.setEffective(EffectiveEnums.FALSE);
        record.setTarget(new BigDecimal("1.44"));
        record.setTargetCondition(1);
        record.setNonce(1);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalStakePORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }
}
