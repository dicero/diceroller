package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import com.dicero.diceroller.form.MemberInfoQueryForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/5
 */
@Slf4j
@Controller
@RequestMapping(value="manager/member")
public class AdminMemberController {
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalInfoPORepository personalInfoPORepository;


    // @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="", method= RequestMethod.GET )
    public String query(Model model) {
        model.addAttribute("memberInfoQueryForm", new MemberInfoQueryForm());
        model.addAttribute("QueryMemberType", MemberInfoQueryForm.QueryMemberType.values());
        return "member/query";
    }

    @RequestMapping(value="/query", method = RequestMethod.POST )
    public String queryPost(@Valid MemberInfoQueryForm memberInfoQueryForm,
                        BindingResult result, Model model) {
        log.info("memberInfoQueryForm:{}", memberInfoQueryForm);
        model.addAttribute("memberInfoQueryForm", memberInfoQueryForm);
        model.addAttribute("QueryMemberType", MemberInfoQueryForm.QueryMemberType.values());
        if (result.hasErrors()) {
            return "member/query";
        }

        if (memberInfoQueryForm.getQueryMemberType().equals(MemberInfoQueryForm.QueryMemberType.MEMBER_ID)) {
            int memberId;
            try {
                memberId = Integer.valueOf(memberInfoQueryForm.getMemberValue());
            } catch (Exception e) { return "member/query"; }
            PersonalInfoPO personalInfoPO = personalInfoPORepository.findByMemberId(memberId);
            model.addAttribute("personalInfoPO", personalInfoPO);
        }
        return "member/query";
    }

}
