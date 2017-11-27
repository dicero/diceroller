package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.dal.mysql.repository.*;
import com.dicero.diceroller.domain.enums.EffectiveEnums;
import com.dicero.diceroller.domain.model.*;
import com.dicero.diceroller.service.personal.PersonalService;
import com.dicero.diceroller.service.play.PlayService;
import com.dicero.diceroller.web.hepler.WebLoginer;
import com.dicero.diceroller.web.interceptor.WebAccess;
import com.dicero.diceroller.web.rest.vo.BillVO;
import com.dicero.diceroller.web.rest.vo.MemberSeedVO;
import com.dicero.diceroller.web.rest.vo.StakeCollectVO;
import com.dicero.diceroller.web.rest.vo.StakeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired PersonalStakeTodayPORepository personalStakeTodayPORepository;
    @Autowired PersonalStakeHistoryPORepository personalStakeHistoryPORepository;
    @Autowired PersonalBillPORepository personalBillPORepository;
    @Autowired PersonalSeedPORepository personalSeedPORepository;
    @Autowired PersonalStakePORepository personalStakePORepository;
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
            @ApiImplicitParam(name = "page", value = "分页，页数", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页，每页总数", required = true, dataType = "Integer", paramType = "query")
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/stakes", produces = "application/json")
    public RestResponse stakes(@ApiIgnore final WebLoginer webLoginer, final int page, final int pageSize) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
                Validate.notNull(page, "page 不能为空");
                Validate.notNull(pageSize, "pageSize 不能为空");
                Validate.isTrue(page <= 0, "page 不能小于0");
                Validate.isTrue(pageSize <= 0, "pageSize 不能小于0");
            }

            @Override
            protected RestResponse process() throws Exception {
                List<PersonalStakePO> personalStakePOList = personalStakePORepository.findAllByMemberIdAndEffective(webLoginer.getId(), EffectiveEnums.TRUE,
                        new PageRequest(page, pageSize, new Sort(Sort.Direction.DESC, new String[]{"create_time"})));

                List<StakeVO> data = new ArrayList<>();
                for (PersonalStakePO personalStakePO : personalStakePOList) {
                    StakeVO stakeVO = new StakeVO();
                    BeanUtils.copyProperties(personalStakePO, stakeVO);
                    data.add(stakeVO);
                }

                return RestResponse.createSuccess(data);
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询每日及历史投注数额")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/stakeCollect", produces = "application/json")
    public RestResponse stakeCollect(@ApiIgnore final WebLoginer webLoginer) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                DataObject dataObject = new DataObject();
                PersonalStakeTodayPO personalStakeTodayPO = personalStakeTodayPORepository.findByMemberIdAndCalDate(webLoginer.getId(), new Date());
                PersonalStakeHistoryPO personalStakeHistoryPO = personalStakeHistoryPORepository.findByMemberId(webLoginer.getId());

                StakeCollectVO todayCollect = new StakeCollectVO().init();
                StakeCollectVO historyCollect = new StakeCollectVO().init();

                if (personalStakeTodayPO != null) {
                    BeanUtils.copyProperties(personalStakeTodayPO, todayCollect);
                }

                if (personalStakeHistoryPO != null) {
                    BeanUtils.copyProperties(personalStakeHistoryPO, historyCollect);
                }

                dataObject.put("todayCollect", todayCollect);
                dataObject.put("historyCollect", historyCollect);
                return RestResponse.createSuccess(dataObject.getData());
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页，页数", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页，每页总数", required = true, dataType = "Integer", paramType = "query")
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/bill", produces = "application/json")
    public RestResponse bill(@ApiIgnore final WebLoginer webLoginer, final int page, final int pageSize) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
                Validate.notNull(page, "page 不能为空");
                Validate.notNull(pageSize, "pageSize 不能为空");
                Validate.isTrue(page <= 0, "page 不能小于0");
                Validate.isTrue(pageSize <= 0, "pageSize 不能小于0");
            }

            @Override
            protected RestResponse process() throws Exception {
                List<PersonalBillPO> personalBillPOList = personalBillPORepository.findAllByMemberId(webLoginer.getId(),
                        new PageRequest(page, pageSize, new Sort(Sort.Direction.DESC, new String[]{"create_time"})));
                List<BillVO> data = new ArrayList<>();

                for (PersonalBillPO personalBillPO : personalBillPOList) {
                    BillVO billVO = new BillVO();
                    BeanUtils.copyProperties(personalBillPO, billVO);
                    data.add(billVO);
                }

                return RestResponse.createSuccess(data);
            }
        }.run();
    }
}
