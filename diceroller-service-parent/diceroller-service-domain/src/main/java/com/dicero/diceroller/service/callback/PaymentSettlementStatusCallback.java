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
 * @version 2017/11/3
 */
public class PaymentSettlementStatusCallback implements SettlementCallbackFunc<Boolean> {

    @Override
    public Boolean runInBack(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums) {
        SettlementStatusEnums settlementStatusEnums;
        String paymentSeqNo = settlementOrderPO.getPaymentSeqNo();
        String clearingCodeList = "";
        if (StringUtils.isNotBlank(settlementOrderPO.getClearingCodeList())) {
            clearingCodeList += settlementOrderPO.getClearingCodeList() + "|";
        }
        clearingCodeList += tradeModeEnums.getClearingCode();


        // NOTE: 支付成功
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            settlementStatusEnums = SettlementStatusEnums.P;
        }

        // NOTE: 支付结算
        else if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)) {
            settlementStatusEnums = SettlementStatusEnums.S;
        }

        // NOTE: 支付撤销
        else if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_CANCEL)) {
            settlementStatusEnums = SettlementStatusEnums.F;
        }

        // NOTE: 支付失败
        else if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_FAIL)) {
            settlementStatusEnums = SettlementStatusEnums.F;
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
