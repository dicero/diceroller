package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.common.util.AmtUtil;
import com.dicero.diceroller.service.bean.RollerBean;
import com.dicero.diceroller.service.bean.MakeResult;
import com.dicero.diceroller.service.play.PlayService;
import com.dicero.diceroller.web.hepler.WebLoginer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;

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

    @Autowired PlayService playService;

    public static void main(String[] args) {
        System.out.println(new BigDecimal("0.00000001").setScale(8,BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal(0.00000001).setScale(8,BigDecimal.ROUND_HALF_UP)));
    }

    // NOTE: 派彩A (1.012-9900) 胜率B(0.01-98,当拖动划线的时候都为整数) 滚存C1, 反滚存C2
    @ApiOperation(value = "手动下注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "amt", value = "押注数额", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "target", value = "滚存", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "targetCondition", value = "押正1, 压反0", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/make", produces = "application/json")
    public RestResponse make(@ApiIgnore final WebLoginer webLoginer, final BigDecimal amt, final BigDecimal target, final int targetCondition) {
        return new RestExecuteContrl() {
            @Override
            protected void validate() throws Exception {
                Validate.notNull(amt, "amt 不能为空");
                Validate.notNull(target, "target 不能为空");
                Validate.notNull(targetCondition, "targetCondition 不能为空");

                if (AmtUtil.compareTo(amt, new BigDecimal(0.00000001)) < 0) {
                    throw CommonDefinedException.ILLEGAL_PARAMES_ERROR("amt 金额不能小于0.00000001");
                }

                if (AmtUtil.compareTo(amt, new BigDecimal(99)) > 0) {
                    throw CommonDefinedException.ILLEGAL_PARAMES_ERROR("amt 金额不能大于99");
                }

                if (AmtUtil.compareTo(target, new BigDecimal(1.99)) < 0) {
                    throw CommonDefinedException.ILLEGAL_PARAMES_ERROR("target 滚存不能小于1.99");
                }

                if (AmtUtil.compareTo(target, new BigDecimal(98.99)) > 0) {
                    throw CommonDefinedException.ILLEGAL_PARAMES_ERROR("target 滚存不能大于98.99");
                }

                if (targetCondition != 1 && targetCondition != 0) {
                    throw CommonDefinedException.ILLEGAL_PARAMES_ERROR("targetCondition 只能选1或者0");
                }
            }

            @Override
            protected RestResponse process() throws Exception {
                RollerBean rollerBean = new RollerBean(AmtUtil.checkAmt(amt), AmtUtil.check(target, 2), targetCondition);
                MakeResult makeResult = playService.roller(webLoginer.getId(), webLoginer.getUsername(), rollerBean);
                if (makeResult != null) {
                    return RestResponse.createSuccess(makeResult);
                } else {
                    return RestResponse.createFailure();
                }

            }
        }.run();
    }

    @ApiOperation(value = "自动下注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "amt", value = "押注数额", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "target", value = "滚存", required = true, dataType = "BigDecimal", paramType = "query"),
            @ApiImplicitParam(name = "condition", value = "押正1, 压反0", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(method = { RequestMethod.POST }, path="/autoMake", produces = "application/json")
    public RestResponse autoMake() {
        return RestResponse.createSuccess();

    }

}
