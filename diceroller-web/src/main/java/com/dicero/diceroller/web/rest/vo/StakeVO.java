package com.dicero.diceroller.web.rest.vo;

import com.dicero.diceroller.domain.enums.FundTypeEnums;
import lombok.Data;
import lombok.ToString;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/2
 */
@Data
@ToString
public class StakeVO {
    private String stakeId;
    private String username;
    private String createTime;
    private FundTypeEnums fundType;
    private String changeAmt;
    private String amt;
    private String target;
    private int targetCondition;
    private String payout;
    private String randomResult;

}
