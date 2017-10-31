package com.dicero.diceroller.service.tss.impl;

import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.enums.TradeStatusEnums;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.tss.TssTradeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
@Service
public class TssTradeServiceImpl implements TssTradeService {


    @Override
    public void trade() {


        boolean resutl = true;
        PersonalMemberPO personalMemberPO = new PersonalMemberPO();
        BigDecimal amt = new BigDecimal("0.000000001");

        PersonalMemberPO buyer = new PersonalMemberPO();


        TradeOrderPO tradeOrderPO = new TradeOrderPO();
        tradeOrderPO.setTradeVoucherNo("");
        tradeOrderPO.setTradeSrcVoucherNo("");
        tradeOrderPO.setTradeAmount(amt);
        tradeOrderPO.setBuyerId(buyer.getMemberId());
        tradeOrderPO.setBuyerAccountNo("");
        tradeOrderPO.setBuyerName("客户");

        tradeOrderPO.setSellerId(100);
        tradeOrderPO.setSellerName("");
        tradeOrderPO.setSellerAccountNo(InnerAccountEnums.COMPANY_FUND_BIT.getAccountNo());

        tradeOrderPO.setRemark("交易");
        tradeOrderPO.setStatus(TradeStatusEnums.INIT.getValue());
    }
}
