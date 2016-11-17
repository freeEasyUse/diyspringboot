package org.freeuse.spbt.test.service;

import org.freeuse.spbt.mybatis.entity.UserInfo;
import org.freeuse.spbt.service.UserInfoService;
import org.freeuse.spbt.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoServiceTest extends BaseTest {

	@Autowired
	private UserInfoService userInfoService;
	
	
	@Test
	public void testInserTranscation() throws Exception{
		UserInfo userInfo = new UserInfo();
		//userInfo.setUsername("user");
		userInfo.setUsername("user1");
		userInfoService.insertUserInfo(userInfo);
	}
	
	
}
