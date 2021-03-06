package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.dal.mysql.repository.InnerAccountPORepository;
import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.domain.model.InnerAccountPO;
import com.dicero.diceroller.tool.AdminTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/5
 */
@Slf4j
@Controller
@RequestMapping(value="manager/account/inner")
public class AdminAccountInnerController {

    @Autowired
    InnerAccountPORepository innerAccountPORepository;


    @AdminAccess({AdminRole.SUPER_ADMIN})
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String accountList(Model model) {
        Map<String, List<InnerAccountPO>> dataMap = new LinkedHashMap<>();
        List<InnerAccountPO> innerAccountPOList = innerAccountPORepository.findAll(new Sort(
                Sort.Direction.ASC, new String[] { "accountTitleNo", "accountNo" }));

        for (InnerAccountPO innerAccountPO : innerAccountPOList) {
            addData(dataMap, innerAccountPO);
        }

        model.addAttribute("dataMap", dataMap);
        model.addAttribute("AdminTool", new AdminTool());
        return "account/inner/list";
    }

    public void addData(Map<String, List<InnerAccountPO>> dataMap, InnerAccountPO innerAccountPO){
        if (dataMap.containsKey(innerAccountPO.getAccountTitleNo())) {
            List<InnerAccountPO> list = dataMap.get(innerAccountPO.getAccountTitleNo());
            if (CollectionUtils.isEmpty(list)) {
                list = new ArrayList<>();
            }
            list.add(innerAccountPO);
        } else {
            List<InnerAccountPO> list = new ArrayList<>();
            list.add(innerAccountPO);
            dataMap.put(innerAccountPO.getAccountTitleNo(), list);
        }
    }
}
