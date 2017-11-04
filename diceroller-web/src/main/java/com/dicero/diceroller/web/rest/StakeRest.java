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
@Api("押注相关")
@RequestMapping("/rest/stake")
public class StakeRest {

    @ApiOperation(value = "手动下注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "amt", value = "押注数额", required = true, dataType = "BigDecimal", paramType = "query", defaultValue=""),
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/createAnonymous", produces = "application/json")
    public RestResponse createAnonymous(String memberName) {
        return RestResponse.createSuccess("创建成功");

    }

}
