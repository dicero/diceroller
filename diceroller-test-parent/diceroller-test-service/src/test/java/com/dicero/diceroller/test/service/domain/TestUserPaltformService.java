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

import java.util.ArrayList;
import java.util.List;

import com.dicero.diceroller.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.dicero.diceroller.domain.model.UserPlatform;
import com.dicero.diceroller.service.domain.UserPlatformService;

public class TestUserPaltformService extends TestBase {

	@Autowired
	UserPlatformService userPlatformService;
	
	@Test
	public void cache() throws InterruptedException{
		UserPlatform record =  new UserPlatform();
		record.setLoginPassword("password");
		record.setLoginUsername("us"+RandomStringUtils.random(5));
		this.userPlatformService.save(record);
		
		UserPlatform record1 = this.userPlatformService.findById(record.getId());
		System.out.println("record1 =>" + record1);
		UserPlatform record2 = this.userPlatformService.findById(record.getId());
		System.out.println("record2 =>" + record2);
		
		this.userPlatformService.update(record.getId(), record.getLoginUsername(), "aaaaaaaa", "ddddd");
		Thread.sleep(5);
		UserPlatform record3 = this.userPlatformService.findById(record.getId());
		System.out.println("record3 =>" + record3);
		UserPlatform record4 = this.userPlatformService.findById(record.getId());
		System.out.println("record4 =>" + record4);
		
		this.userPlatformService.deleteById(record.getId());
		Thread.sleep(5);
		UserPlatform record5 = this.userPlatformService.findById(record.getId());
		System.out.println("record5 =>" + record5);
	}
	
	@Test
	public void save() {
		UserPlatform record =  new UserPlatform();
		record.setLoginPassword("password");
		record.setLoginUsername("你好");
		this.userPlatformService.save(record);
	}

	@Test
	public void findByLoginUsername() {
		UserPlatform userPlatformVO = this.userPlatformService.findByLoginUsername("username");
		Assert.assertNull(userPlatformVO);
	}
	
	@Test
	public void findById() {
		UserPlatform userPlatformVO = userPlatformService.findById(1L);
		Assert.assertNull(userPlatformVO);
	}
	
	@Test
	public void findAll() {
		Page<UserPlatform> userPlatformVOs = userPlatformService.findAll(0, 10);
		System.out.println("Number=>"+userPlatformVOs.getNumber());
		System.out.println("Size=>"+userPlatformVOs.getSize());
		System.out.println("Content=>"+userPlatformVOs.getContent().size());
		// Assert.assertThat(userPlatformVOs.getSize(),Matchers.greaterThan(0));
		// Assert.assertThat(userPlatformVOs.getNumber(),Matchers.greaterThan(0));
		for (UserPlatform userPlatform : userPlatformVOs.getContent()) {
			System.out.println("userPlatform=>"+userPlatform);
		}
	}
	
	@Test
	public void update() {
		Long id = 10000000L;
		String loginUsername = "zhangsan";
		String loginPassword = "mima";
		int rows = userPlatformService.update(id, loginUsername, loginPassword, "nickname");
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
