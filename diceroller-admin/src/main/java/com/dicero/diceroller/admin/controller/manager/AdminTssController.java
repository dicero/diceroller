package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.dal.mysql.repository.*;
import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.domain.enums.NoTypeEnums;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.form.OrderQueryForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/5
 */
@Slf4j
@Controller
@RequestMapping(value="manager/tss")
public class AdminTssController {

    @Autowired TradeOrderPORepository tradeOrderPORepository;
    @Autowired SettlementOrderPORepository settlementOrderPORepository;
    @Autowired SettlementCarrierPORepository settlementCarrierPORepository;
    @Autowired ClearingOrderInnerPORepository clearingOrderInnerPORepository;
    @Autowired ClearingOrderOuterPORepository clearingOrderOuterPORepository;


    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String queryGet(Model model) {
        model.addAttribute("orderQueryForm", new OrderQueryForm());
        model.addAttribute("NoTypeEnums", NoTypeEnums.values());
        return "tss/query";
    }

    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/query", method= RequestMethod.POST)
    public String queryPost(@Valid OrderQueryForm orderQueryForm,
                            BindingResult result, Model model) {
        log.info("orderQueryForm:{}", orderQueryForm);
        if (result.hasErrors()) {
            model.addAttribute("NoTypeEnums", NoTypeEnums.values());
            return "tss/query";
        }


        if (NoTypeEnums.PAYMENT_SEQ_NO.equals(orderQueryForm.getNoTypeEnums())) {
            TradeOrderPO tradeOrderPO = tradeOrderPORepository.findByTradeVoucherNo(orderQueryForm.getNo());
            model.addAttribute("tradeOrderPO", tradeOrderPO);
            SettlementOrderPO settlementOrderPO = settlementOrderPORepository.findByPaymentSeqNo(orderQueryForm.getNo());
            model.addAttribute("settlementOrderPO", settlementOrderPO);
            List<SettlementCarrierPO> settlementCarrierPOList = settlementCarrierPORepository.findAllByPaymentSeqNo(orderQueryForm.getNo());
            model.addAttribute("settlementCarrierPOList", settlementCarrierPOList);
        }
        model.addAttribute("NoTypeEnums", NoTypeEnums.values());
        model.addAttribute("orderQueryForm", orderQueryForm);
        return "tss/query";
    }

}
