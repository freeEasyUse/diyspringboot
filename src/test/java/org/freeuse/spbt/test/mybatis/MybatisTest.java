package org.freeuse.spbt.test.mybatis;

import java.util.List;
import java.util.Map;

import org.freeuse.spbt.mybatis.entity.UserInfo;
import org.freeuse.spbt.mybatis.mapper.UserInfoMapper;
import org.freeuse.spbt.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisTest extends BaseTest {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	
	@Test
	public void testSelect(){
		List<UserInfo> allList = userInfoMapper.selectAll();
		System.out.println(allList);
	}
	
	
	@Test
	public void testGroupSelect(){
		List<Map<String, Object>> result = userInfoMapper.findGroupByUserType();
		System.out.println(result);
	}
}
