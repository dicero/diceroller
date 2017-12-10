package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.dal.mysql.repository.PersonalSeedPORepository;
import com.dicero.diceroller.domain.model.PersonalSeedPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalSeedPORepositoryTest extends TestBase {
    @Autowired
    PersonalSeedPORepository PersonalSeedPORepository;

    @Test
    public void findByIdTest() {
        // PersonalSeedPO record = PersonalSeedPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void findAllByMemberIdTest() {
         List<PersonalSeedPO> recordList = PersonalSeedPORepository.findAllByMemberId(2000000020, new PageRequest(0, 2, new Sort(Sort.Direction.DESC, new String[] { "defaultUse", "createTime" }) ));
         println(recordList);
         Assert.assertNotNull(recordList);
    }


    @Test
    public void saveTest() {
        PersonalSeedPO record = new PersonalSeedPO();
        record.setMemberId(2000000021);
        record.setClientSeed("2222223333334444445555666");
        record.setServerSeed("2222223333334444445555666");
        record.setServerSeedHash(EncryptUtil.SHA256(record.getServerSeed()));
        record.setDefaultUse(1);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalSeedPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }
}
