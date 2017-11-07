package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalInfoPORepositoryTest extends TestBase {
    @Autowired
    PersonalInfoPORepository PersonalInfoPORepository;

    @Test
    public void findByIdTest() {
        // PersonalInfoPO record = PersonalInfoPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        PersonalInfoPO record = new PersonalInfoPO();
        record.setMemberId(2000000000);
        record.setNotifyEmail("Jie@gemail.com");
        record.setNotifyPhone("009933412328343");
        record.setNotifyBitAddress("4534u5453985934858345843589329854353254");
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalInfoPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }

    @Test
    public void findByMemberIdTest() {
         PersonalInfoPO record = PersonalInfoPORepository.findByMemberId(1);
         println(record);
         Assert.assertNotNull(record);
    }
}
