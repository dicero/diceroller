package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakeTodayPORepository;
import com.dicero.diceroller.domain.model.PersonalStakeTodayPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalStakeTodayPORepositoryTest extends TestBase {
    @Autowired
    PersonalStakeTodayPORepository PersonalStakeTodayPORepository;

    @Test
    public void findByIdTest() {
        // PersonalStakeTodayPO record = PersonalStakeTodayPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        PersonalStakeTodayPO record = new PersonalStakeTodayPO();
        record.setMemberId(testMemberId);
        record.setAllStakeAmt(BigDecimal.TEN);
        record.setAllWinAmt(BigDecimal.ONE);
        record.setAllLoseAmt(BigDecimal.ONE);
        record.setAllLoseGames(1);
        record.setAllLoseGames(1);
        record.setWinningPos(new BigDecimal("1.4"));
        record.setCalDate(new Date());
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalStakeTodayPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }
}
