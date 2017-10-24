package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.service.facade.memcached.CacheBean;
import com.dicero.diceroller.service.facade.memcached.MemcachedManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**   
* <p></p>
* @author zengningzong
*/
@RestController
@Api("缓存相关")
@RequestMapping("/rest/cache")
public class CacheRest {
	@Value("${server.address}")
	private String _ADDRESS;
	
	@ApiOperation(value = "查询留言ITEM缓存")
    @ApiImplicitParams({
    })
    @RequestMapping(method = { RequestMethod.GET }, path="/query", produces = "application/json")
    public RestResponse query() {
		List<Map<String, Object>> lists = new ArrayList<>();
		Map<String, Object> data = MemcachedManager.LOCAGE_ITEM_CACHE.getMaps();
		for (Entry<String, Object> map : data.entrySet()) {
			Map<String, Object> item = new HashMap<>();
			item.put(map.getKey(), map.getValue());
			item.put("清除", "http://" + _ADDRESS + ":8080/rest/cache/clear?key=" + CacheBean.getKey(map.getKey()));
			lists.add(item);
		}
        return RestResponse.createSuccess("获取成功", lists);
    }
	
	@ApiOperation(value = "清除留言缓存")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "key", value = "缓存键值", required = true, dataType = "String", paramType = "query", defaultValue=""),
    })
    @RequestMapping(method = { RequestMethod.GET }, path="/clear", produces = "application/json")
    public RestResponse clear(String key) {
		if(StringUtils.isBlank(key)) {
			return RestResponse.createFailure("key不能为空");
		}
		if(MemcachedManager.clearLocageCache(key)) {
			return RestResponse.createSuccess("删除成功");
		} else {
			return RestResponse.createFailure("删除失败");
		}
    }
}
