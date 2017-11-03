package com.dicero.diceroller.test.service;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.SettlementOrderPORepository;
import com.dicero.diceroller.dal.mysql.repository.TradeOrderPORepository;
import com.dicero.diceroller.domain.enums.OuterAccountEnums;
import com.dicero.diceroller.domain.enums.SettlementStatusEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.enums.TradeStatusEnums;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.settlement.InterfaceSettlementService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/3
 */
public class SettlementServiceTest extends TestBase {
    @Autowired
    TradeOrderPORepository tradeOrderPORepository;
    @Autowired
    SettlementOrderPORepository settlementOrderPORepository;

    @Resource
    InterfaceSettlementService paymentSettlementStrategy;


    @Test
    public void settlementTest(){


//        TradeModeEnums tradeModeEnums_2 = TradeModeEnums.PAYMENT_SETTLEMENT;
//        SettlementOrderPO settlementOrderPO_2 = new SettlementOrderPO();
//        settlementOrderPO_2.setSessionId(RandomUtil.randomUuid("SId"));
//        settlementOrderPO_2.setPaymentSeqNo(tradeOrderPO.getTradeVoucherNo());
//        settlementOrderPO_2.setClearingCode(tradeModeEnums_2.getClearingCode());
//        settlementOrderPO_2.setStatus(SettlementStatusEnums.W.name());
//        settlementOrderPO_2.setCreateTime(now);
//        settlementOrderPO_2.setUpdateTime(now);
//        settlementOrderPORepository.save(settlementOrderPO_2);
//        paymentSettlementStrategy.settlement(settlementOrderPO_2, tradeModeEnums_2);
    }
}
