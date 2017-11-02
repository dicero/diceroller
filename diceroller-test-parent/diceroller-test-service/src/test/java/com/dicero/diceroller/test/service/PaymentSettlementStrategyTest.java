package com.dicero.diceroller.test.service;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.domain.enums.DRCREnums;
import com.dicero.diceroller.domain.enums.PartyIdEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.service.settlement.impl.PaymentSettlementStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
public class PaymentSettlementStrategyTest extends TestBase {

    @Autowired
    PaymentSettlementStrategy paymentSettlementStrategy;

    @Test
    public void test(){
    }

    @Test
    public void saveListTest(){
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();
        BigDecimal amt = new BigDecimal("0.00000001");
        String paymentSeqNo = RandomUtil.randomPaymentSeq();
        String clearingCode = "1";
        String sessionId = RandomUtil.randomUuid("CI");

        // NOTE 内场-借方
        ClearingOrderInnerPO drClearingOrderInnerPO = new ClearingOrderInnerPO();
        drClearingOrderInnerPO.setSessionId(sessionId);
        drClearingOrderInnerPO.setPaymentSeqNo(paymentSeqNo);
        drClearingOrderInnerPO.setClearingCode(clearingCode);
        drClearingOrderInnerPO.setPartyRole(PartyRoleEnums.PAYEE.getValue());
        drClearingOrderInnerPO.setPartyId(PartyIdEnums.INNER_MEMBER.getValue());
        drClearingOrderInnerPO.setAccountNo("100000000");
        drClearingOrderInnerPO.setAmt(amt);
        drClearingOrderInnerPO.setDrcr(DRCREnums.DR.name());
        drClearingOrderInnerPO.setCreateTime(now);
        drClearingOrderInnerPO.setUpdateTime(now);
        clearingOrderInnerPOList.add(drClearingOrderInnerPO);

        // NOTE 内场-贷方
        ClearingOrderInnerPO crClearingOrderInnerPO = new ClearingOrderInnerPO();
        crClearingOrderInnerPO.setSessionId(sessionId);
        crClearingOrderInnerPO.setPaymentSeqNo(paymentSeqNo);
        crClearingOrderInnerPO.setClearingCode(clearingCode);
        crClearingOrderInnerPO.setPartyRole(PartyRoleEnums.PAYER.getValue());
        crClearingOrderInnerPO.setPartyId(PartyIdEnums.INNER_MEMBER.getValue());
        crClearingOrderInnerPO.setAccountNo("333333222222");
        crClearingOrderInnerPO.setAmt(amt);
        crClearingOrderInnerPO.setDrcr(DRCREnums.CR.name());
        crClearingOrderInnerPO.setCreateTime(now);
        crClearingOrderInnerPO.setUpdateTime(now);
        clearingOrderInnerPOList.add(crClearingOrderInnerPO);

        println(clearingOrderInnerPOList);
        Assert.assertNotNull(clearingOrderInnerPOList);

    }
}
