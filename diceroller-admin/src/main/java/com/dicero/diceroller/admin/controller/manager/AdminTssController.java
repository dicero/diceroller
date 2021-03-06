package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.dal.mysql.repository.*;
import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.domain.enums.NoTypeEnums;
import com.dicero.diceroller.domain.model.*;
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
    @Autowired InnerAccountDetailPORepository innerAccountDetailPORepository;
    @Autowired OuterAccountDetailPORepository outerAccountDetailPORepository;


    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String queryGet(Model model) {

        OrderQueryForm form = new OrderQueryForm();
        form.setNo("P0001711040018250SEQ0375221");
        form.setNoTypeEnums(NoTypeEnums.PAYMENT_SEQ_NO);

        model.addAttribute("orderQueryForm",form );
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
            List<ClearingOrderInnerPO> clearingOrderInnerPOList = clearingOrderInnerPORepository.findAllByPaymentSeqNo(orderQueryForm.getNo());
            model.addAttribute("clearingOrderInnerPOList", clearingOrderInnerPOList);
            List<ClearingOrderOuterPO> clearingOrderOuterPOList = clearingOrderOuterPORepository.findAllByPaymentSeqNo(orderQueryForm.getNo());
            model.addAttribute("clearingOrderOuterPOList", clearingOrderOuterPOList);
            List<InnerAccountDetailPO> innerAccountDetailPOList = innerAccountDetailPORepository.findAllByPaymentSeqNo(orderQueryForm.getNo());
            model.addAttribute("innerAccountDetailPOList", innerAccountDetailPOList);
            List<OuterAccountDetailPO> outerAccountDetailPOList = outerAccountDetailPORepository.findAllByPaymentSeqNo(orderQueryForm.getNo());
            model.addAttribute("outerAccountDetailPOList", outerAccountDetailPOList);
        }
        model.addAttribute("NoTypeEnums", NoTypeEnums.values());
        model.addAttribute("orderQueryForm", orderQueryForm);
        return "tss/query";
    }

}
