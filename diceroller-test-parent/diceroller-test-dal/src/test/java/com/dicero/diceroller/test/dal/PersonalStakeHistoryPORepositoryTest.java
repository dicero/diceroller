package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakeHistoryPORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import com.dicero.diceroller.domain.model.PersonalStakeHistoryPO;
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
public class PersonalStakeHistoryPORepositoryTest extends TestBase {
    @Autowired
    PersonalStakeHistoryPORepository PersonalStakeHistoryPORepository;

    @Test
    public void findByIdTest() {
        // PersonalStakeHistoryPO record = PersonalStakeHistoryPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        PersonalStakeHistoryPO record = new PersonalStakeHistoryPO();
        record.setMemberId(testMemberId);
        record.setAllStakeAmt(BigDecimal.TEN);
        record.setAllWinAmt(BigDecimal.ONE);
        record.setAllLoseAmt(BigDecimal.ONE);
        record.setAllLoseGames(1);
        record.setAllLoseGames(1);
        record.setWinningPos(new BigDecimal("1.4"));
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalStakeHistoryPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }
}
