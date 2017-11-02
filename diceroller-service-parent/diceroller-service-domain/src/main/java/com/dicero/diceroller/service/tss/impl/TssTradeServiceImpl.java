package com.dicero.diceroller.service.tss.impl;

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
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.settlement.InterfaceSettlementService;
import com.dicero.diceroller.service.tss.TssTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
@Service
public class TssTradeServiceImpl extends BaseService implements TssTradeService {

    @Autowired TradeOrderPORepository tradeOrderPORepository;
    @Autowired SettlementOrderPORepository settlementOrderPORepository;

    @Resource
    InterfaceSettlementService paymentSettlementStrategy;

    @Override
    public void trade() {


        boolean resutl = true;
        PersonalMemberPO personalMemberPO = new PersonalMemberPO();
        BigDecimal amt = new BigDecimal("0.000000001");

        PersonalMemberPO buyer = new PersonalMemberPO();
        buyer.setMemberId(2000000000);


        TradeOrderPO tradeOrderPO = new TradeOrderPO();
        tradeOrderPO.setTradeVoucherNo(RandomUtil.randomPaymentSeq());
        tradeOrderPO.setTradeSrcVoucherNo(RandomUtil.randomUuid("REQ"));
        tradeOrderPO.setTradeAmount(amt);

        tradeOrderPO.setBuyerId(buyer.getMemberId());
        tradeOrderPO.setBuyerAccountNo(OuterAccountEnums.get201Account(buyer.getMemberId()));
        tradeOrderPO.setBuyerName("客户");

        tradeOrderPO.setSellerId(OuterAccountEnums.PLATFORM.getMemberId());
        tradeOrderPO.setSellerName(OuterAccountEnums.PLATFORM.getName());
        tradeOrderPO.setSellerAccountNo(OuterAccountEnums.get201Account(OuterAccountEnums.PLATFORM.getMemberId()));

        tradeOrderPO.setRemark("交易");
        tradeOrderPO.setStatus(TradeStatusEnums.INIT.getValue());
        tradeOrderPO.setCreateTime(now);
        tradeOrderPO.setUpdateTime(now);
        tradeOrderPORepository.save(tradeOrderPO);



        TradeModeEnums tradeModeEnums = TradeModeEnums.PAYMENT_SUCCESS;
        SettlementOrderPO settlementOrderPO = new SettlementOrderPO();
        settlementOrderPO.setSessionId(RandomUtil.randomUuid("SId"));
        settlementOrderPO.setPaymentSeqNo(tradeOrderPO.getTradeVoucherNo());
        settlementOrderPO.setClearingCode(tradeModeEnums.getClearingCode());
        settlementOrderPO.setStatus(SettlementStatusEnums.W.name());
        settlementOrderPO.setCreateTime(now);
        settlementOrderPO.setUpdateTime(now);
        settlementOrderPORepository.save(settlementOrderPO);

        paymentSettlementStrategy.settlement(settlementOrderPO, tradeModeEnums);

    }
}
