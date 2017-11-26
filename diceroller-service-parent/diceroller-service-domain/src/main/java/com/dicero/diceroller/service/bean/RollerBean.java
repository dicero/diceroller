package com.dicero.diceroller.service.bean;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RollerBean implements Serializable{
    private BigDecimal amt;
    private BigDecimal target;
    private int targetCondition;
}
