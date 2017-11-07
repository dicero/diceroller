package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakeHistoryPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakePORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.domain.model.PersonalStakeHistoryPO;
import com.dicero.diceroller.domain.model.PersonalStakePO;
import com.dicero.diceroller.form.MemberInfoQueryForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
@RequestMapping(value="manager/member")
public class AdminMemberController {
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalInfoPORepository personalInfoPORepository;
    @Autowired PersonalStakeHistoryPORepository personalStakeHistoryPORepository;
    @Autowired PersonalStakePORepository personalStakePORepository;


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
            PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberId(memberId);
            model.addAttribute("personalMemberPO", personalMemberPO);
            PersonalInfoPO personalInfoPO = personalInfoPORepository.findByMemberId(memberId);
            model.addAttribute("personalInfoPO", personalInfoPO);
            PersonalStakeHistoryPO personalStakeHistoryPO = personalStakeHistoryPORepository.findByMemberId(memberId);
            model.addAttribute("personalStakeHistoryPO", personalStakeHistoryPO);
            List<PersonalStakePO> personalStakePOList = personalStakePORepository.findAllByMemberId(memberId,
                    new PageRequest(0, 20, new Sort(Sort.Direction.DESC, new String[]{"createTime"})));
            model.addAttribute("personalStakePOList", personalStakePOList);

        }
        return "member/query";
    }

}
