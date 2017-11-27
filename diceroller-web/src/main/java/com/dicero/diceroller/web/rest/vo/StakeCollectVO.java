package com.dicero.diceroller.web.rest.vo;

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
public class StakeCollectVO implements Serializable {
    private Timestamp createTime;
    private BigDecimal allStakeAmt;
    private BigDecimal allWinAmt;
    private BigDecimal allLoseAmt;
    private int allWinGames;
    private int allLoseGames;
    private BigDecimal winningPos;

    public StakeCollectVO init(){
        this.allStakeAmt = BigDecimal.ZERO;
        this.allWinAmt = BigDecimal.ZERO;
        this.allLoseAmt = BigDecimal.ZERO;
        this.allWinGames = 0;
        this.allLoseGames = 0;
        this.winningPos = BigDecimal.ZERO;
        return this;
    }
}
