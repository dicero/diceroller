package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.AuditLogPORepository;
import com.dicero.diceroller.domain.model.AuditLogPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class AuditLogPORepositoryTest extends TestBase {
    @Autowired
    AuditLogPORepository AuditLogPORepository;

    @Test
    public void findByIdTest() {
        // AuditLogPO record = AuditLogPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}
