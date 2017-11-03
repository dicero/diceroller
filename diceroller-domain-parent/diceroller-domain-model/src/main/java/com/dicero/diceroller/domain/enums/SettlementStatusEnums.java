package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 * 状态：W-待结算；P-结算中；S-结算成功；F-结算失败；
 * @author znz
 * @version 2017/10/31
 */
public enum SettlementStatusEnums {
    // NOTE: W-待结算
    W(),
    // NOTE: P-结算中
    P(),
    // NOTE: S-结算成功
    S(),
    // NOTE: R-驳回
    R(),
    // NOTE: F-结算失败
    F(),
    // NOTE: C-转存中
    C(),
    // NOTE: E-转存成功
    E();
}
