package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.domain.enums.DRCREnums;
import com.dicero.diceroller.domain.enums.PartyIdEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.settlement.ControlSettlementService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public class ControlSettlementServiceImpl extends BaseService implements ControlSettlementService {

    @Override
    public void buildInnerClearing(ClearAccount drClearAccount, ClearAccount crClearAccount) {
        BigDecimal amt = new BigDecimal("0.00000001");
        String paymentSeqNo = "";
        String clearingCode = "";
        String sessionId = "";

        // NOTE 内场-借方
        ClearingOrderInnerPO drClearingOrderInnerPO = new ClearingOrderInnerPO();
        drClearingOrderInnerPO.setSessionId(sessionId);
        drClearingOrderInnerPO.setPaymentSeqNo(paymentSeqNo);
        drClearingOrderInnerPO.setClearingCode(clearingCode);
        drClearingOrderInnerPO.setPartyRole(PartyRoleEnums.PAYEE.getValue());
        drClearingOrderInnerPO.setPartyId(PartyIdEnums.INNER_MEMBER.getValue());
        drClearingOrderInnerPO.setAccountNo(drClearAccount.getAccountNo());
        drClearingOrderInnerPO.setAmt(amt);
        drClearingOrderInnerPO.setDrcr(DRCREnums.DR.name());
        drClearingOrderInnerPO.setCreateTime(now);
        drClearingOrderInnerPO.setUpdateTime(now);

        // NOTE 内场-贷方
        ClearingOrderInnerPO crClearingOrderInnerPO = new ClearingOrderInnerPO();
        crClearingOrderInnerPO.setSessionId(sessionId);
        crClearingOrderInnerPO.setPaymentSeqNo(paymentSeqNo);
        crClearingOrderInnerPO.setClearingCode(clearingCode);
        crClearingOrderInnerPO.setPartyRole(PartyRoleEnums.PAYER.getValue());
        crClearingOrderInnerPO.setPartyId(PartyIdEnums.INNER_MEMBER.getValue());
        crClearingOrderInnerPO.setAccountNo(crClearAccount.getAccountNo());
        crClearingOrderInnerPO.setAmt(amt);
        crClearingOrderInnerPO.setDrcr(DRCREnums.CR.name());
        crClearingOrderInnerPO.setCreateTime(now);
        crClearingOrderInnerPO.setUpdateTime(now);
    }

    @Override
    public void buildOuterClearing(ClearAccount clearAccount) {
        BigDecimal amt = new BigDecimal("0.00000001");

        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();
        clearingOrderOuterPO.setSessionId("");
        clearingOrderOuterPO.setAccountNo(clearAccount.getAccountNo());
        clearingOrderOuterPO.setPartyId(PartyIdEnums.OUTER_MEMBER.getValue());
        clearingOrderOuterPO.setPartyRole(PartyRoleEnums.PAYER.getValue());
        clearingOrderOuterPO.setAmt(amt);
        clearingOrderOuterPO.setClearingCode("");
        clearingOrderOuterPO.setCreateTime(now);
        clearingOrderOuterPO.setUpdateTime(now);
    }
}
