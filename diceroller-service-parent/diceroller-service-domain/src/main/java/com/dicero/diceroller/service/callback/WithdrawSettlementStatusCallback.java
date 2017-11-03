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
public class WithdrawSettlementStatusCallback implements SettlementCallbackFunc<Boolean> {

    @Override
    public Boolean runInBack(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums) {
        SettlementStatusEnums settlementStatusEnums;
        String paymentSeqNo = settlementOrderPO.getPaymentSeqNo();
        String clearingCodeList = "";
        if (StringUtils.isNotBlank(settlementOrderPO.getClearingCodeList())) {
            clearingCodeList += settlementOrderPO.getClearingCodeList() + "|";
        }
        clearingCodeList += tradeModeEnums.getClearingCode();


        // NOTE: 出款申请
        if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_APPLY)) {
            settlementStatusEnums = SettlementStatusEnums.P;
        }

        // NOTE: 出款驳回
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_REFUSE)) {
            settlementStatusEnums = SettlementStatusEnums.R;
        }

        // NOTE: 出款成功
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_SUCCESS)) {
            settlementStatusEnums = SettlementStatusEnums.C;
        }

        // NOTE: 出款撤销
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_FAIL)) {
            settlementStatusEnums = SettlementStatusEnums.F;
        }

        // NOTE: 出款转存
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
