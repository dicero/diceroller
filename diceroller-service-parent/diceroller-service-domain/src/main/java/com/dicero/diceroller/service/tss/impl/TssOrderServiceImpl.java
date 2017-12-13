package com.dicero.diceroller.service.tss.impl;

import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.TradeOrderPORepository;
import com.dicero.diceroller.dal.mysql.repository.WithdrawOrderPORepository;
import com.dicero.diceroller.domain.enums.AuditTypeEnums;
import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.enums.OuterAccountEnums;
import com.dicero.diceroller.domain.enums.TradeStatusEnums;
import com.dicero.diceroller.domain.model.AuditPersonalSubmitPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.domain.model.WithdrawOrderPO;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.tss.TssOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
@Slf4j
@Service
public class TssOrderServiceImpl extends BaseService implements TssOrderService {
    @Autowired WithdrawOrderPORepository withdrawOrderPORepository;
    @Autowired TradeOrderPORepository tradeOrderPORepository;

    @Override
    public void storePaymentOrder() {

    }

    @Override
    public void storeRechargeOrder() {

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean storeWithdrawOrder(String requestNo, Integer memberId, String username, BigDecimal amt, String address) {
        AuditPersonalSubmitPO auditPersonalSubmitPO = new AuditPersonalSubmitPO();
        auditPersonalSubmitPO.setCreateTime(now());
        auditPersonalSubmitPO.setCreateTime(now());
        auditPersonalSubmitPO.setRequestNo(requestNo);
        auditPersonalSubmitPO.setCreator(username);
        auditPersonalSubmitPO.setMemberId(memberId);
        auditPersonalSubmitPO.setAuditType(AuditTypeEnums.WITHDRAW);

        TradeOrderPO tradeOrderPO = new TradeOrderPO();
        tradeOrderPO.setTradeVoucherNo(RandomUtil.randomPaymentSeq());
        tradeOrderPO.setTradeSrcVoucherNo(requestNo);
        tradeOrderPO.setTradeAmount(amt);

        tradeOrderPO.setBuyerId(0);
        tradeOrderPO.setBuyerAccountNo(InnerAccountEnums.BANK_ETH.getAccountNo());
        tradeOrderPO.setBuyerName("内部户");

        tradeOrderPO.setSellerId(memberId);
        tradeOrderPO.setSellerName(username);
        tradeOrderPO.setSellerAccountNo(OuterAccountEnums.get201Account(memberId));

        tradeOrderPO.setRemark("提现");
        tradeOrderPO.setStatus(TradeStatusEnums.INIT);
        tradeOrderPO.setCreateTime(now());
        tradeOrderPO.setUpdateTime(now());
        tradeOrderPORepository.save(tradeOrderPO);

        WithdrawOrderPO withdrawOrderPO = new WithdrawOrderPO();
        withdrawOrderPO.setMemberId(memberId);
        withdrawOrderPO.setPaymentSeqNo(tradeOrderPO.getTradeVoucherNo());
        withdrawOrderPO.setAddress(address);
        withdrawOrderPO.setUpdateTime(now());
        withdrawOrderPO.setCreateTime(now());
        withdrawOrderPO = withdrawOrderPORepository.save(withdrawOrderPO);

        return true;
    }

    @Override
    public void storePresentOrder() {

    }
}
