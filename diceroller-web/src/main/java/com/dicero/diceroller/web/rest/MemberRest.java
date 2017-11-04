package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/4
 */
@RestController
@Api("会员相关")
@RequestMapping("/rest/member")
public class MemberRest {


    @ApiOperation(value = "创建匿名会员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberName", value = "会员名称", required = true, dataType = "String", paramType = "query", defaultValue=""),
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/createAnonymous", produces = "application/json")
    public RestResponse createAnonymous(String memberName) {
        return RestResponse.createSuccess("创建成功");
    }



}
