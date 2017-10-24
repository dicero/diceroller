package com.dicero.diceroller.common.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by kdlbj__ on 16/10/11.
 */
public class PageUtil {

    public static PageRequest getPager(int pn, int ps) {
        if (pn < 0) {
            pn = 10;
        }

        if (ps <= 0) {
            ps = 10;
        }

        return new PageRequest(pn, ps);
    }

    public static PageRequest getPager(int pn, int ps, Sort sort) {
        if (pn < 0) {
            pn = 10;
        }

        if (ps <= 0) {
            ps = 10;
        }

        return new PageRequest(pn, ps, sort);
    }
}
