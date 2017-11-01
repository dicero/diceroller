package com.dicero.diceroller.service.bean;

import com.dicero.diceroller.domain.model.SettlementCarrierPO;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
public class InnerClearingEntity implements Serializable {
    private SettlementCarrierPO settlementCarrierPO;
    private ClearAccount drClearAccount;
    private ClearAccount crClearAccount;

    public SettlementCarrierPO getSettlementCarrierPO() {
        return settlementCarrierPO;
    }

    public void setSettlementCarrierPO(SettlementCarrierPO settlementCarrierPO) {
        this.settlementCarrierPO = settlementCarrierPO;
    }

    public ClearAccount getDrClearAccount() {
        return drClearAccount;
    }

    public void setDrClearAccount(ClearAccount drClearAccount) {
        this.drClearAccount = drClearAccount;
    }

    public ClearAccount getCrClearAccount() {
        return crClearAccount;
    }

    public void setCrClearAccount(ClearAccount crClearAccount) {
        this.crClearAccount = crClearAccount;
    }
}
