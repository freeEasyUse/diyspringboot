package org.freeuse.spbt.service.imple;

import org.freeuse.spbt.mybatis.entity.UserInfo;
import org.freeuse.spbt.mybatis.mapper.UserInfoMapper;
import org.freeuse.spbt.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImple implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int insertUserInfo(UserInfo userInfo) throws Exception {

		int result = userInfoMapper.insert(userInfo);
		if(userInfo.getUsername().equals("user")){
			throw new Exception("抛出异常 进行回滚");
		}
		return result;
	}

}
