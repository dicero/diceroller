package com.dicero.diceroller.web.rest.vo;

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
public class StakeCollectVO implements Serializable {
    private String createTime;
    private String allStakeAmt;
    private String allWinAmt;
    private String allLoseAmt;
    private int allWinGames;
    private int allLoseGames;
    private String winningPos;

    public StakeCollectVO init(){
        this.allStakeAmt = "0.00";
        this.allWinAmt = "0.00";
        this.allLoseAmt = "0.00";
        this.allWinGames = 0;
        this.allLoseGames = 0;
        this.winningPos = "0.00";
        return this;
    }
}
