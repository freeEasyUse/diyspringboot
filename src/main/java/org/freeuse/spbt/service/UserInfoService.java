package org.freeuse.spbt.service;

import org.freeuse.spbt.mybatis.entity.UserInfo;

public interface UserInfoService {

	public int insertUserInfo(UserInfo userInfo) throws Exception;
	
}
