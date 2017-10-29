package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
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
}
