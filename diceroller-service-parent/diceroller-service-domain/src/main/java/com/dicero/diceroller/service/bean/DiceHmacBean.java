package com.dicero.diceroller.service.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/26
 */
@Data
@ToString
public class DiceHmacBean implements Serializable{
    private String stakeId;
    private RollerBean rollerBean;
    private boolean win;
    private BigDecimal changeAmt;

    public DiceHmacBean(String stakeId, RollerBean rollerBean) {
        this.stakeId = stakeId;
        this.rollerBean = rollerBean;
        this.win = false;
        this.changeAmt = BigDecimal.ZERO;
    }
}
