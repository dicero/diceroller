package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.web.hepler.WebLoginer;
import com.dicero.diceroller.web.interceptor.WebAccess;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
@RestController
@Api("查询相关")
@RequestMapping("/rest/query")
public class QueryRest extends AbstractRest {

    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalInfoPORepository personalInfoPORepository;

    @WebAccess
    @ApiOperation(value = "查询用户登录状态")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/state", produces = "application/json")
    public RestResponse state() {
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
            protected void validate() throws Exception {
            }

            @Override
            protected RestResponse process() throws Exception {
                return RestResponse.createSuccess();
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
            protected void validate() throws Exception {
            }

            @Override
            protected RestResponse process() throws Exception {
                HashMap<String, BigDecimal> data = new HashMap<>();
                data.put("balance", new BigDecimal("0.00000002"));
                return RestResponse.createSuccess(data);
            }
        }.run();
    }

    @WebAccess
    @ApiOperation(value = "查询押注")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/bits", produces = "application/json")
    public RestResponse bits(@ApiIgnore final WebLoginer webLoginer) {
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
    @ApiOperation(value = "查询种子")
    @ApiImplicitParams({})
    @RequestMapping(method = { RequestMethod.POST }, path="/seed", produces = "application/json")
    public RestResponse seed(@ApiIgnore final WebLoginer webLoginer) {
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
