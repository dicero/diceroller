package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.service.personal.PersonalService;
import com.dicero.diceroller.service.play.PlayService;
import com.dicero.diceroller.web.hepler.WebLoginer;
import com.dicero.diceroller.web.interceptor.WebAccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/4
 */
@Slf4j
@RestController
@Api("会员相关")
@RequestMapping("/rest/member")
public class MemberRest extends AbstractRest {
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalService personalService;
    @Autowired PlayService playService;

    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password", value = "新密码", required = true, dataType = "String", paramType = "query"),
    })
    @WebAccess
    @RequestMapping(method = { RequestMethod.POST }, path="/password", produces = "application/json")
    public RestResponse password(@ApiIgnore final WebLoginer webLoginer , final String password) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
                Validate.notBlank(password, "password 不能为空");
                Validate.isTrue(password.length() > 10, "password 不能少于10个字符串");
                Validate.isTrue(password.length() < 20, "password 不能超过20个字符串");
            }

            @Override
            protected RestResponse process() throws Exception {
                boolean  result = personalService.setPersonalPassword(webLoginer.getId(), password);
                return result ? RestResponse.createSuccess() : RestResponse.createFailure();
            }
        }.run();
    }

    @ApiOperation(value = "修改用户种子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientSeed", value = "客户端种子", required = true, dataType = "String", paramType = "query")
    })
    @WebAccess
    @RequestMapping(method = { RequestMethod.POST }, path="/seed", produces = "application/json")
    public RestResponse seed(@ApiIgnore final WebLoginer webLoginer , final String clientSeed) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
                Validate.notBlank(clientSeed, "clientSeed 不能为空");
                Validate.isTrue(clientSeed.length() > 30, "clientSeed 不能少于30个字符串");
            }

            @Override
            protected RestResponse process() throws Exception {
                boolean result = playService.updatePersonalSeedByTmp(webLoginer.getId(), clientSeed);
                return result ? RestResponse.createSuccess() : RestResponse.createFailure();
            }
        }.run();
    }

}
