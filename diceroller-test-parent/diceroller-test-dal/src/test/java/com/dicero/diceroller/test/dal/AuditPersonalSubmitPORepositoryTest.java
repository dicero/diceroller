package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.domain.enums.AuditTypeEnums;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.AuditPersonalSubmitPORepository;
import com.dicero.diceroller.domain.model.AuditPersonalSubmitPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class AuditPersonalSubmitPORepositoryTest extends TestBase {
    @Autowired
    AuditPersonalSubmitPORepository AuditPersonalSubmitPORepository;

    @Test
    public void findByIdTest() {
        // AuditPersonalSubmitPO record = AuditPersonalSubmitPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        AuditPersonalSubmitPO record = new AuditPersonalSubmitPO();
        record.setCreateTime(now);
        record.setCreateTime(now);
        record.setRequestNo("213123121212");
        record.setCreator("");
        record.setMemberId(12312312);
        record.setAuditType(AuditTypeEnums.WITHDRAW);
         println(record);
         Assert.assertNotNull(record);
    }
}
