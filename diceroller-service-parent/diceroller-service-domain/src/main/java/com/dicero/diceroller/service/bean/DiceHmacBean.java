package com.dicero.diceroller.service.bean;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class DiceHmacBean implements Serializable{
    private String stakeId;
    private RollerBean rollerBean;
    private boolean win;
}
