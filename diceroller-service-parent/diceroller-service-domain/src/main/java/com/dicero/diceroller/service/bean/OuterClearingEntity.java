package com.dicero.diceroller.service.bean;

import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
public class OuterClearingEntity implements Serializable {
    private SettlementCarrierPO settlementCarrierPO;
    private ClearAccount clearAccount;
    private PartyRoleEnums partyRoleEnums;

    public SettlementCarrierPO getSettlementCarrierPO() {
        return settlementCarrierPO;
    }

    public void setSettlementCarrierPO(SettlementCarrierPO settlementCarrierPO) {
        this.settlementCarrierPO = settlementCarrierPO;
    }

    public ClearAccount getClearAccount() {
        return clearAccount;
    }

    public void setClearAccount(ClearAccount clearAccount) {
        this.clearAccount = clearAccount;
    }

    public PartyRoleEnums getPartyRoleEnums() {
        return partyRoleEnums;
    }

    public void setPartyRoleEnums(PartyRoleEnums partyRoleEnums) {
        this.partyRoleEnums = partyRoleEnums;
    }
}
