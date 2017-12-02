package com.dicero.diceroller.service.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

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

    public DiceHmacBean(String stakeId, RollerBean rollerBean) {
        this.stakeId = stakeId;
        this.rollerBean = rollerBean;
        this.win = false;
    }
}
