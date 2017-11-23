package com.dicero.diceroller.test.core;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.core.coin.contracts.GreeterApplication;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/18
 */
public class GreeterContractIT  extends TestBase {
    @Test
    public void testGreeterContract() throws Exception {
        GreeterApplication.main(new String[]{ });
    }
}
