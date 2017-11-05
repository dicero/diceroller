/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dicero.diceroller.test.service.domain;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.domain.model.UserPlatformPO;
import com.dicero.diceroller.service.domain.UserPlatformService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class TestUserPaltformService extends TestBase {

	@Autowired
	UserPlatformService userPlatformService;
	
	@Test
	public void cache() throws InterruptedException{
		UserPlatformPO record =  new UserPlatformPO();
		record.setLoginPassword("password");
		record.setLoginUsername("us"+RandomStringUtils.random(5));
		this.userPlatformService.save(record);
		
		UserPlatformPO record1 = this.userPlatformService.findById(record.getId());
		System.out.println("record1 =>" + record1);
		UserPlatformPO record2 = this.userPlatformService.findById(record.getId());
		System.out.println("record2 =>" + record2);
		
		this.userPlatformService.update(record.getId(), record.getLoginUsername(), "aaaaaaaa", AdminRole.ADMIN, "");
		Thread.sleep(5);
		UserPlatformPO record3 = this.userPlatformService.findById(record.getId());
		System.out.println("record3 =>" + record3);
		UserPlatformPO record4 = this.userPlatformService.findById(record.getId());
		System.out.println("record4 =>" + record4);
		
		this.userPlatformService.deleteById(record.getId());
		Thread.sleep(5);
		UserPlatformPO record5 = this.userPlatformService.findById(record.getId());
		System.out.println("record5 =>" + record5);
	}
	
	@Test
	public void save() {
		UserPlatformPO record =  new UserPlatformPO();
		record.setLoginPassword("admin01");
		record.setLoginUsername("admin");
		this.userPlatformService.save(record);
	}

	@Test
	public void findByLoginUsername() {
		UserPlatformPO userPlatformVO = this.userPlatformService.findByLoginUsername("username");
		Assert.assertNull(userPlatformVO);
	}
	
	@Test
	public void findById() {
		UserPlatformPO userPlatformVO = userPlatformService.findById(1L);
		Assert.assertNull(userPlatformVO);
	}
	
	@Test
	public void findAll() {
		Page<UserPlatformPO> userPlatformVOs = userPlatformService.findAll(0, 10);
		System.out.println("Number=>"+userPlatformVOs.getNumber());
		System.out.println("Size=>"+userPlatformVOs.getSize());
		System.out.println("Content=>"+userPlatformVOs.getContent().size());
		// Assert.assertThat(userPlatformVOs.getSize(),Matchers.greaterThan(0));
		// Assert.assertThat(userPlatformVOs.getNumber(),Matchers.greaterThan(0));
		for (UserPlatformPO userPlatform : userPlatformVOs.getContent()) {
			System.out.println("userPlatform=>"+userPlatform);
		}
	}
	
	@Test
	public void update() {
		Long id = 1L;
		String loginUsername = "zhangsan";
		String loginPassword = "mima";
		int rows = userPlatformService.update(id, loginUsername, loginPassword, AdminRole.ADMIN, "nickname");
		Assert.assertEquals(rows, 1);
	}
	
	@Test
	public void deleteByIdIn() {
		List<Long> ids =  new ArrayList<>();
		long rows = userPlatformService.deleteByIdIn(ids);
		System.out.println("rows=>"+rows);
		Assert.assertEquals(rows, 2);
	}
}
