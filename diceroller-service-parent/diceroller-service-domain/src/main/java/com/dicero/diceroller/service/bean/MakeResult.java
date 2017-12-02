package com.dicero.diceroller.service.bean;

import com.dicero.diceroller.domain.enums.FundTypeEnums;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/27
 */
@Data
@ToString
public class MakeResult implements Serializable{
    private FundTypeEnums fundType;
    private String changeAmt;
    private String stakeId;
    private String randomResult;
}
