package com.dicero.diceroller.service.tss.impl;

import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.dal.mysql.repository.TradeAccessPORepository;
import com.dicero.diceroller.dal.mysql.repository.TradeOrderPORepository;
import com.dicero.diceroller.domain.enums.AccessNodeEnums;
import com.dicero.diceroller.domain.enums.OuterAccountEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.enums.TradeStatusEnums;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.domain.model.TradeAccessPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.settlement.InterfaceSettlementService;
import com.dicero.diceroller.service.settlement.SettlementOrderService;
import com.dicero.diceroller.service.tss.TssTradeService;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired TradeOrderPORepository tradeOrderPORepository;
    @Autowired TradeAccessPORepository tradeAccessPORepository;
    @Autowired SettlementOrderService settlementOrderService;

    @Resource InterfaceSettlementService paymentSettlementStrategy;

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
        tradeOrderPO.setStatus(TradeStatusEnums.INIT);
        tradeOrderPO.setCreateTime(now());
        tradeOrderPO.setUpdateTime(now());
        tradeOrderPORepository.save(tradeOrderPO);


        TradeModeEnums tradeModeEnums = TradeModeEnums.PAYMENT_FAIL;
        SettlementOrderPO settlementOrderPO = settlementOrderService.createSettlementOrder(tradeOrderPO);
        paymentSettlementStrategy.settlement(settlementOrderPO, tradeModeEnums);

    }


    @Override
    public TradeAccessPO createAccessTrade(Integer memberId) {
        TradeAccessPO record = new TradeAccessPO();
        record.setMemberId(memberId);
        record.setNode(AccessNodeEnums.PASS);
        record.setVersion(0);
        record.setCreateTime(now());
        record.setUpdateTime(now());
        record = tradeAccessPORepository.save(record);
        return record;
    }


    @Override
    public boolean safeAccess(String accessToken) {
        if (StringUtils.isNotBlank(accessToken)) {
            PersonalMemberPO personalMemberPO = personalMemberPORepository.findByPlayAccessToken(accessToken);
            return personalMemberPO == null ? false : true;
        }
        return false;
    }

    @Override
    public boolean queryAccess(Integer memberId) {
        TradeAccessPO tradeAccessPO = tradeAccessPORepository.findByMemberIdAndNode(memberId, AccessNodeEnums.PASS);
        if (tradeAccessPO != null && AccessNodeEnums.PASS.equals(tradeAccessPO.getNode())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean judgeAccess(Integer memberId) {
        return access(memberId, "judge");
    }

    @Override
    public boolean resetAccess(Integer memberId) {
        return access(memberId, "reset");
    }

    private boolean access(Integer memberId, String type){
        if (type.equals("judge")) {
            TradeAccessPO tradeAccessPO = tradeAccessPORepository.findByMemberIdAndNode(memberId, AccessNodeEnums.PASS);
            if (tradeAccessPO != null) {
                int rows = tradeAccessPORepository.updateNodeById(tradeAccessPO.getId(), tradeAccessPO.getVersion() + 1, AccessNodeEnums.WAIT);
                if(rows == 1) return true;
            }
        } else if(type.equals("reset")){
            TradeAccessPO tradeAccessPO = tradeAccessPORepository.findByMemberIdAndNode(memberId, AccessNodeEnums.WAIT);
            if (tradeAccessPO != null) {
                int rows = tradeAccessPORepository.updateNodeById(tradeAccessPO.getId(), tradeAccessPO.getVersion() + 1, AccessNodeEnums.PASS);
                if(rows == 1) return true;
            }
        }

        return false;
    }
}
