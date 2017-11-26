package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.web.hepler.WebLoginer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RestController
@Api("押注相关")
@RequestMapping("/rest/stake")
public class StakeRest extends AbstractRest {

    @ApiOperation(value = "手动下注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "amt", value = "押注数额", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "target", value = "滚存", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "condition", value = "押正>, 压反<", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/make", produces = "application/json")
    public RestResponse make(@ApiIgnore final WebLoginer webLoginer) {
        return RestResponse.createSuccess("创建成功");

    }

    @ApiOperation(value = "自动下注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "amt", value = "押注数额", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "target", value = "滚存", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "condition", value = "押正>, 压反<", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/autoMake", produces = "application/json")
    public RestResponse autoMake(String memberName) {
        return RestResponse.createSuccess("创建成功");

    }

}
