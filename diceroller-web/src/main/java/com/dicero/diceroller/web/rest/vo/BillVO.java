package com.dicero.diceroller.web.rest.vo;

import com.dicero.diceroller.domain.enums.TradeTypeEnums;
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
public class BillVO implements Serializable{
    private String seqNo;
    private Timestamp createTime;
    private TradeTypeEnums tradeType;
    private String tradeStatus;
    private BigDecimal tradeAmt;
    private String tradeTitle;
    private String tradeInfo;
    private String stakeId;
}
