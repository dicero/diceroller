package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalSeedPORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.domain.model.PersonalSeedPO;
import com.dicero.diceroller.domain.model.PersonalSeedTmpPO;
import com.dicero.diceroller.service.personal.PersonalService;
import com.dicero.diceroller.service.play.PlayService;
import com.dicero.diceroller.web.hepler.WebLoginer;
import com.dicero.diceroller.web.interceptor.WebAccess;
import com.dicero.diceroller.web.rest.vo.MemberSeedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
@Slf4j
@RestController
@Api("查询相关")
@RequestMapping("/rest/query")
public class QueryRest extends AbstractRest {

    @Autowired PlayService playService;
    @Autowired PersonalService personalService;
    @Autowired PersonalSeedPORepository personalSeedPORepository;
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalInfoPORepository personalInfoPORepository;

    @WebAccess
    @ApiOperation(value = "查询用户登录状态")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/state", produces = "application/json")
    public RestResponse state(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                log.info("webLoginer:{}", webLoginer);
                DataObject dataObject = new DataObject();
                dataObject.put("username", webLoginer.getUsername());
                return RestResponse.createSuccess(dataObject.getData());
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询用户是否有密码")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/password", produces = "application/json")
    public RestResponse password(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                DataObject dataObject = new DataObject();
                PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberId(webLoginer.getId());
                if (personalMemberPO != null && StringUtils.isNotBlank(personalMemberPO.getPwd())) {
                    dataObject.put("has", "1");
                } else {
                    dataObject.put("has", "0");
                }
                return RestResponse.createSuccess(dataObject.getData());
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询会员信息")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/info", produces = "application/json")
    public RestResponse info(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                DataObject dataObject = new DataObject();
                PersonalInfoPO personalInfoPO = personalInfoPORepository.findByMemberId(webLoginer.getId());
                if (personalInfoPO != null) {
                    dataObject.put("username", webLoginer.getUsername());
                    dataObject.put("notifyEmail", personalInfoPO.getNotifyEmail());
                    dataObject.put("notifyPhone", personalInfoPO.getNotifyPhone());
                    dataObject.put("notifyBitAddress", personalInfoPO.getNotifyBitAddress());
                }
                return RestResponse.createSuccess(dataObject.getData());
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询会员余额")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/balance", produces = "application/json")
    public RestResponse balance(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                DataObject dataObject = new DataObject();
                dataObject.put("balance", "0.00000002");
                return RestResponse.createSuccess(dataObject.getData());
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询押注")
    @ApiImplicitParams({

    })
    @RequestMapping(method = { RequestMethod.POST }, path="/stakes", produces = "application/json")
    public RestResponse stakes(@ApiIgnore final WebLoginer webLoginer, int page, int pageSize) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                return RestResponse.createSuccess();
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询充值地址")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/address", produces = "application/json")
    public RestResponse address(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                PersonalInfoPO personalInfoPO = personalInfoPORepository.findByMemberId(webLoginer.getId());
                if (personalInfoPO != null) {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("address", personalInfoPO.getNotifyBitAddress());
                    return RestResponse.createSuccess(data);
                } else {
                    return RestResponse.createFailure();
                }
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询可用种子")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/availableSeed", produces = "application/json")
    public RestResponse availableSeed(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                DataObject dataObject = new DataObject();

                PersonalSeedTmpPO personalSeedTmpPO = playService.createPersonalSeedTmp(webLoginer.getId());

                dataObject.put("clientSeed", personalSeedTmpPO.getClientSeed());
                dataObject.put("serverSeedHash", EncryptUtil.SHA256(personalSeedTmpPO.getServerSeed()));

                return RestResponse.createSuccess(dataObject.getData());
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询拥有种子")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/possessSeed", produces = "application/json")
    public RestResponse possessSeed(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
            }

            @Override
            protected RestResponse process() throws Exception {
                DataObject dataObject = new DataObject();

                List<PersonalSeedPO> personalSeedPOList = personalSeedPORepository.findAllByMemberId(webLoginer.getId());
                List<MemberSeedVO> memberSeedVOList = new ArrayList<>();

                for (PersonalSeedPO personalSeedPO : personalSeedPOList) {
                    MemberSeedVO memberSeedVO = new MemberSeedVO();
                    BeanUtils.copyProperties(personalSeedPO, memberSeedVO);
                    memberSeedVOList.add(memberSeedVO);
                }

                dataObject.put("list", memberSeedVOList);
                return RestResponse.createSuccess(dataObject.getData());
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询账单")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/bill", produces = "application/json")
    public RestResponse bill(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
            }

            @Override
            protected RestResponse process() throws Exception {
                return RestResponse.createSuccess();
            }
        }.run();
    }
}
