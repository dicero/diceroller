package com.dicero.diceroller.service.dpm.impl;

import com.dicero.diceroller.dal.mysql.repository.InnerAccountPORepository;
import com.dicero.diceroller.dal.mysql.repository.OuterAccountPORepository;
import com.dicero.diceroller.dal.mysql.repository.OuterAccountSubsetPORepository;
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
    @Autowired OuterAccountPORepository outerAccountPORepository;
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

                innerAccountPO.setBalance(balance);
                if(innerAccountPORepository.saveAndFlush(innerAccountPO) == null ) {
                    return false;
                }
            }
            return true;
        }
        return false;

    }

    @Override
    public boolean changeBalance(ClearingOrderOuterPO clearingOrderOuterPO) {
        OuterAccountPO outerAccountPO = outerAccountPORepository.findByAccountNo(clearingOrderOuterPO.getAccountNo());
        // TODO: 状态拦截
        if (outerAccountPO.getStatusMap().equals("1")) {

        }

        OuterAccountSubsetPO outerAccountSubsetPO = outerAccountSubsetPORepository.findByAccountNo(clearingOrderOuterPO.getAccountNo());
        BigDecimal balance = outerAccountSubsetPO.getBalance();

        if (clearingOrderOuterPO.getPartyRole().equals(PartyRoleEnums.PAYER.name())) {
            balance = balance.add(clearingOrderOuterPO.getAmt());

        } else {
            balance = balance.subtract(clearingOrderOuterPO.getAmt());
        }

        outerAccountSubsetPO.setBalance(balance);
        if(outerAccountSubsetPORepository.saveAndFlush(outerAccountSubsetPO) != null) return true;
        return false;
    }

}
