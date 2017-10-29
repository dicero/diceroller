package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.AuditSysSubmitPORepository;
import com.dicero.diceroller.domain.model.AuditSysSubmitPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class AuditSysSubmitPORepositoryTest extends TestBase {
    @Autowired
    AuditSysSubmitPORepository AuditSysSubmitPORepository;

    @Test
    public void findByIdTest() {
        // AuditSysSubmitPO record = AuditSysSubmitPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}
