package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestCode;
import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.service.personal.PersonalService;
import com.dicero.diceroller.web.hepler.HelperCookie;
import io.swagger.annotations.*;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
@RestController
@Api("登录相关")
@RequestMapping("/rest/auth")
public class AuthRest extends AbstractRest {
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalService personalService;

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/login", produces = "application/json")
    public RestResponse login(final HttpServletRequest request, final String username, final String password) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
                Validate.notBlank(username, "username 不能为空");
                Validate.notBlank(password, "password 不能为空");
            }

            @Override
            protected RestResponse process() throws Exception {
                PersonalMemberPO personalMemberPO = personalService.login(username, password);
                if (personalMemberPO != null) {
                    HelperCookie.setLoginWeb(request, personalMemberPO);
                    return RestResponse.createSuccess();
                } else {
                    return RestResponse.createFailure();
                }
            }
        }.run();
    }

    @ApiOperation(value = "登出")
    @ApiImplicitParams({ })
    @RequestMapping(method = { RequestMethod.POST }, path="/logout", produces = "application/json")
    public RestResponse logout(final HttpServletRequest request) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception { }

            @Override
            protected RestResponse process() throws Exception {
                HelperCookie.removeLoginWeb(request);
                return RestResponse.createSuccess();
            }
        }.run();
    }

    @ApiOperation(value = "注册会员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "注册登录名", required = true, dataType = "String", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 100, message = "成功"),
            @ApiResponse(code = 101, message = "用户名已存在"),
            @ApiResponse(code = 102, message = "用户未登录"),
            @ApiResponse(code = 103, message = "重复的请求"),
            @ApiResponse(code = 198, message = "请求参数校检不通过"),
            @ApiResponse(code = 199, message = "失败")
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/register", produces = "application/json")
    public RestResponse register(final HttpServletRequest request, final String username) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
                Validate.notBlank(username, "username 不能为空");
                Validate.isTrue(username.length() < 10, "username 不能超过10个字符串");
            }

            @Override
            protected RestResponse process() throws Exception {
                PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberAccount(username);
                if (personalMemberPO != null) {
                    return RestResponse.createFailure(RestCode.USER_NAME_EXIST);
                }
                personalMemberPO = personalService.register(username);
                if (personalMemberPO != null) {
                    HelperCookie.setLoginWeb(request, personalMemberPO);
                    return RestResponse.createSuccess();
                } else {
                    return RestResponse.createFailure();
                }

            }
        }.run();
    }
}
