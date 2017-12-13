package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakeHistoryPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakePORepository;
import com.dicero.diceroller.domain.enums.AdminRole;
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


    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="", method= RequestMethod.GET )
    public String query(Model model) {
        model.addAttribute("memberInfoQueryForm", new MemberInfoQueryForm());
        model.addAttribute("QueryMemberType", MemberInfoQueryForm.QueryMemberType.values());
        return "member/query";
    }

    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/query", method = RequestMethod.POST )
    public String queryPost(@Valid MemberInfoQueryForm memberInfoQueryForm,
                        BindingResult result, Model model) {
        log.info("memberInfoQueryForm:{}", memberInfoQueryForm);
        model.addAttribute("memberInfoQueryForm", memberInfoQueryForm);
        model.addAttribute("QueryMemberType", MemberInfoQueryForm.QueryMemberType.values());
        if (result.hasErrors()) {
            return "member/query";
        }

        int memberId = 0;
        if (memberInfoQueryForm.getQueryMemberType().equals(MemberInfoQueryForm.QueryMemberType.MEMBER_ID)) {
            try {
                memberId = Integer.valueOf(memberInfoQueryForm.getMemberValue());
            } catch (Exception e) { return "member/query"; }
            PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberId(memberId);
            if(personalMemberPO != null) {
                model.addAttribute("personalMemberPO", personalMemberPO);
                PersonalInfoPO personalInfoPO = personalInfoPORepository.findByMemberId(memberId);
                model.addAttribute("personalInfoPO", personalInfoPO);

                buildPersonalStakeData(model, memberId);
            }


        } else if (memberInfoQueryForm.getQueryMemberType().equals(MemberInfoQueryForm.QueryMemberType.ACCOUNT_NAME)) {
            PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberAccount(memberInfoQueryForm.getMemberValue());
            if (personalMemberPO != null) {
                memberId = personalMemberPO.getMemberId();
                model.addAttribute("personalMemberPO", personalMemberPO);
                PersonalInfoPO personalInfoPO = personalInfoPORepository.findByMemberId(memberId);
                model.addAttribute("personalInfoPO", personalInfoPO);

                buildPersonalStakeData(model, memberId);
            }

        } else if (memberInfoQueryForm.getQueryMemberType().equals(MemberInfoQueryForm.QueryMemberType.EMAIL)) {
            PersonalInfoPO personalInfoPO = personalInfoPORepository.findByNotifyEmail(memberInfoQueryForm.getMemberValue());
            findPersonalInfo(model, personalInfoPO);


        } else if (memberInfoQueryForm.getQueryMemberType().equals(MemberInfoQueryForm.QueryMemberType.PHONE)) {
            PersonalInfoPO personalInfoPO = personalInfoPORepository.findByNotifyPhone(memberInfoQueryForm.getMemberValue());
            findPersonalInfo(model, personalInfoPO);


        } else if (memberInfoQueryForm.getQueryMemberType().equals(MemberInfoQueryForm.QueryMemberType.PHONE)) {
            PersonalInfoPO personalInfoPO = personalInfoPORepository.findByNotifyBitAddress(memberInfoQueryForm.getMemberValue());
            findPersonalInfo(model, personalInfoPO);
        }


        return "member/query";
    }

    private void findPersonalInfo(Model model, PersonalInfoPO personalInfoPO) {
        if (personalInfoPO != null) {
            int memberId = personalInfoPO.getMemberId();
            model.addAttribute("personalInfoPO", personalInfoPO);
            PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberId(memberId);
            model.addAttribute("personalMemberPO", personalMemberPO);

            buildPersonalStakeData(model, memberId);
        }
    }

    private void buildPersonalStakeData(Model model, int memberId) {
        PersonalStakeHistoryPO personalStakeHistoryPO = personalStakeHistoryPORepository.findByMemberId(memberId);
        model.addAttribute("personalStakeHistoryPO", personalStakeHistoryPO);
        List<PersonalStakePO> personalStakePOList = personalStakePORepository.findAllByMemberId(memberId,
                new PageRequest(0, 20, new Sort(Sort.Direction.DESC, new String[]{"createTime"})));
        model.addAttribute("personalStakePOList", personalStakePOList);
    }

}
