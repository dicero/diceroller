package com.dicero.diceroller.web.rest.vo;

import com.dicero.diceroller.domain.enums.FundTypeEnums;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/27
 */
@Data
@ToString
public class StakeVO implements Serializable{
    private Timestamp createTime;
    private FundTypeEnums fundType;
    private BigDecimal changeAmt;
    private String stakeId;
}
