package com.dicero.diceroller.tool;

import com.dicero.diceroller.domain.enums.InnerAccountTitleEnums;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.FormatConfig;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/5
 */
@DefaultKey("admin")
public class AdminTool extends FormatConfig {

    public String printAccountName(String accountTitleNo) {
        if (StringUtils.isBlank(accountTitleNo)) {
            return "11";
        }
        for (InnerAccountTitleEnums innerAccountTitleEnums : InnerAccountTitleEnums.values()) {
            if (innerAccountTitleEnums.getTitleNo().equals(accountTitleNo)) {
                return innerAccountTitleEnums.getDesc();
            }
        }
        return "22";
    }
}
