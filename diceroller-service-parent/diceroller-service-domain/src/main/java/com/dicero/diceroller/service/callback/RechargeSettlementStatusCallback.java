package com.dicero.diceroller.service.callback;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.dal.mysql.repository.SettlementOrderPORepository;
import com.dicero.diceroller.domain.enums.SettlementStatusEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.service.bean.SpringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/4
 */
public class RechargeSettlementStatusCallback implements SettlementCallbackFunc<Boolean> {
    @Override
    public Boolean runInBack(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums) {
        SettlementStatusEnums settlementStatusEnums;
        String paymentSeqNo = settlementOrderPO.getPaymentSeqNo();
        String clearingCodeList = "";
        if (StringUtils.isNotBlank(settlementOrderPO.getClearingCodeList())) {
            clearingCodeList += settlementOrderPO.getClearingCodeList() + "|";
        }
        clearingCodeList += tradeModeEnums.getClearingCode();


        // NOTE: 入款成功
        if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_SUCCESS)) {
            settlementStatusEnums = SettlementStatusEnums.P;
        }

        // NOTE: 入款结算
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_SETTLEMENT)) {
            settlementStatusEnums = SettlementStatusEnums.C;
        }

        // NOTE: 入款撤销
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_CANCEL)) {
            settlementStatusEnums = SettlementStatusEnums.F;
        }

        // NOTE: 入款转存
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_CLEAR)) {
            settlementStatusEnums = SettlementStatusEnums.E;
        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("回调找不到指令");
        }

        SpringUtils.getBean(SettlementOrderPORepository.class)
                .updateStatusAndClearingCodeListByPaymentSeqNo(paymentSeqNo,
                        settlementStatusEnums.name(), clearingCodeList);

        return true;
    }
}
