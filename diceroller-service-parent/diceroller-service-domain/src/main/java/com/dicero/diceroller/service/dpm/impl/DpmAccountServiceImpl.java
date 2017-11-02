package com.dicero.diceroller.service.dpm.impl;

import com.dicero.diceroller.dal.mysql.repository.*;
import com.dicero.diceroller.domain.enums.DRCREnums;
import com.dicero.diceroller.domain.enums.PartyIdEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.model.*;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.dpm.DpmAccountService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
@Service
public class DpmAccountServiceImpl extends BaseService implements DpmAccountService {

    @Autowired InnerAccountPORepository innerAccountPORepository;
    @Autowired InnerAccountDetailPORepository innerAccountDetailPORepository;
    @Autowired OuterAccountPORepository outerAccountPORepository;
    @Autowired OuterAccountDetailPORepository outerAccountDetailPORepository;
    @Autowired OuterAccountSubsetPORepository outerAccountSubsetPORepository;

    @Override
    public BigDecimal queryBalanceByAccountNo(PartyIdEnums partyIdEnums, String accountNo) {
        if (partyIdEnums.equals(PartyIdEnums.INNER_MEMBER)) {
            InnerAccountPO innerAccountPO = innerAccountPORepository.findByAccountNo(accountNo);
            return innerAccountPO.getBalance();
        } else  if (partyIdEnums.equals(PartyIdEnums.OUTER_MEMBER)) {
            OuterAccountSubsetPO outerAccountSubsetPO = outerAccountSubsetPORepository.findByAccountNo(accountNo);
            return outerAccountSubsetPO.getBalance();
        }
        return null;

    }

    @Override
    public boolean changeBalance(List<ClearingOrderInnerPO> clearingOrderInnerPOList) {

        // TODO: 缺少事务批量操作,
        if (CollectionUtils.isNotEmpty(clearingOrderInnerPOList)) {
            for (ClearingOrderInnerPO clearingOrderInnerPO : clearingOrderInnerPOList) {
                InnerAccountPO innerAccountPO = innerAccountPORepository.findByAccountNo(clearingOrderInnerPO.getAccountNo());
                BigDecimal balance = innerAccountPO.getBalance();

                if (innerAccountPO.getDrcr().equals(clearingOrderInnerPO.getDrcr())) {
                    balance = balance.add(clearingOrderInnerPO.getAmt());

                } else {
                    balance = balance.subtract(clearingOrderInnerPO.getAmt());
                }

                InnerAccountDetailPO innerAccountDetailPO = new InnerAccountDetailPO();
                innerAccountDetailPO.setAccountNo(innerAccountPO.getAccountNo());
                innerAccountDetailPO.setDrcr(clearingOrderInnerPO.getDrcr());
                innerAccountDetailPO.setPaymentSeqNo(clearingOrderInnerPO.getPaymentSeqNo());
                innerAccountDetailPO.setVoucherNo(clearingOrderInnerPO.getSessionId());
                innerAccountDetailPO.setTxnAmt(clearingOrderInnerPO.getAmt());
                innerAccountDetailPO.setTxnRemark("内场交易记录");
                innerAccountDetailPO.setBeforeAmt(innerAccountPO.getBalance());
                innerAccountDetailPO.setAfterAmt(balance);
                innerAccountDetailPO.setCreateTime(now);
                innerAccountDetailPO.setUpdateTime(now);

                innerAccountPO.setBalance(balance);
                innerAccountPORepository.save(innerAccountPO);
                innerAccountDetailPORepository.save(innerAccountDetailPO);
            }
            return true;
        }
        return false;

    }

    @Override
    public boolean changeBalance(ClearingOrderOuterPO clearingOrderOuterPO, String paymentSeqNo) {
        OuterAccountPO outerAccountPO = outerAccountPORepository.findByAccountNo(clearingOrderOuterPO.getAccountNo());
        // TODO: 状态拦截
        if (outerAccountPO.getStatusMap().equals("1")) {

        }

        OuterAccountSubsetPO outerAccountSubsetPO = outerAccountSubsetPORepository.findByAccountNo(clearingOrderOuterPO.getAccountNo());
        BigDecimal balance = outerAccountSubsetPO.getBalance();

        DRCREnums drcr;
        if (clearingOrderOuterPO.getPartyRole().equals(PartyRoleEnums.PAYER.name())) {
            balance = balance.add(clearingOrderOuterPO.getAmt());
            drcr = DRCREnums.CR;
        } else {
            balance = balance.subtract(clearingOrderOuterPO.getAmt());
            drcr = DRCREnums.DR;
        }

        OuterAccountDetailPO outerAccountDetailPO = new OuterAccountDetailPO();
        outerAccountDetailPO.setAccountNo(outerAccountSubsetPO.getAccountNo());
        outerAccountDetailPO.setDrcr(drcr.name());
        outerAccountDetailPO.setPaymentSeqNo(paymentSeqNo);
        outerAccountDetailPO.setVoucherNo(clearingOrderOuterPO.getSessionId());
        outerAccountDetailPO.setTxnAmt(clearingOrderOuterPO.getAmt());
        outerAccountDetailPO.setTxnRemark("内场交易记录");
        outerAccountDetailPO.setBeforeAmt(outerAccountSubsetPO.getBalance());
        outerAccountDetailPO.setAfterAmt(balance);
        outerAccountDetailPO.setCreateTime(now);
        outerAccountDetailPO.setUpdateTime(now);

        outerAccountSubsetPO.setBalance(balance);
        outerAccountSubsetPORepository.saveAndFlush(outerAccountSubsetPO);
        outerAccountDetailPORepository.save(outerAccountDetailPO);
        return false;
    }

}
