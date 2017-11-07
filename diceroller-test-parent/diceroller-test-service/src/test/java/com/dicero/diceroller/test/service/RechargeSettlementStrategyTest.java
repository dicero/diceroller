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
public class RechargeSettlementStrategyTest extends TestBase {
    @Autowired
    TradeOrderPORepository tradeOrderPORepository;
    @Autowired
    SettlementOrderPORepository settlementOrderPORepository;
    @Resource
    InterfaceSettlementService rechargeSettlementStrategy;

    @Test
    public void settlementTest(){
        BigDecimal amt = new BigDecimal("0.00000005");

        PersonalMemberPO buyer = new PersonalMemberPO();
        buyer.setMemberId(2000000000);


        TradeOrderPO tradeOrderPO = new TradeOrderPO();
        tradeOrderPO.setTradeVoucherNo(RandomUtil.randomPaymentSeq());
        tradeOrderPO.setTradeSrcVoucherNo(RandomUtil.randomUuid("REQ"));
        tradeOrderPO.setTradeAmount(amt);

        tradeOrderPO.setBuyerId(buyer.getMemberId());
        tradeOrderPO.setBuyerAccountNo(OuterAccountEnums.get201Account(buyer.getMemberId()));
        tradeOrderPO.setBuyerName("客户");

        tradeOrderPO.setRemark("充值");
        tradeOrderPO.setStatus(TradeStatusEnums.INIT);
        tradeOrderPO.setCreateTime(now);
        tradeOrderPO.setUpdateTime(now);
        tradeOrderPORepository.save(tradeOrderPO);



        TradeModeEnums tradeModeEnums = TradeModeEnums.FUND_IN_SUCCESS;
        SettlementOrderPO settlementOrderPO = new SettlementOrderPO();
        settlementOrderPO.setSessionId(RandomUtil.randomUuid("SId"));
        settlementOrderPO.setPaymentSeqNo(tradeOrderPO.getTradeVoucherNo());
        // settlementOrderPO.setClearingCode(tradeModeEnums.getClearingCode());
        settlementOrderPO.setStatus(SettlementStatusEnums.W);
        settlementOrderPO.setCreateTime(now);
        settlementOrderPO.setUpdateTime(now);
        settlementOrderPORepository.save(settlementOrderPO);

        rechargeSettlementStrategy.settlement(settlementOrderPO, tradeModeEnums);
    }
}
