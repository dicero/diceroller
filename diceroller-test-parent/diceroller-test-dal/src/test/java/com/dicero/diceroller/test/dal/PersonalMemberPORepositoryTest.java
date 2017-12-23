package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.MD5Util;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalMemberPORepositoryTest extends TestBase {
    @Autowired
    PersonalMemberPORepository PersonalMemberPORepository;

    @Test
    public void findByIdTest() {
        // PersonalMemberPO record = PersonalMemberPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        PersonalMemberPO personalMemberPO = new PersonalMemberPO();
        personalMemberPO.setMemberAccount("11111");
        personalMemberPO.setPlayAccessToken(MD5Util.sign("901"+ System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(6), "dice2099311X"));
        personalMemberPO.setCreateTime(now);
        personalMemberPO.setUpdateTime(now);

        personalMemberPO = PersonalMemberPORepository.save(personalMemberPO);
         println(personalMemberPO);
         Assert.assertNotNull(personalMemberPO);
    }


    @Test
    public void findByAccessTokenTest() {
         PersonalMemberPO record = PersonalMemberPORepository.findByPlayAccessToken("1111");
         println(record);
         Assert.assertNotNull(record);
    }

    @Test
    public void updatePasswordByMemberIdTest() {
         int record = PersonalMemberPORepository.updatePasswordByMemberId(2000000010, "1111111111");
         println(record);
         Assert.assertNotNull(record);
    }
}
