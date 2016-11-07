package org.freeuse.spbt.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.freeuse.spbt.mybatis.config.BaseMapper;
import org.freeuse.spbt.mybatis.entity.UserInfo;

public interface UserInfoMapper extends BaseMapper<UserInfo>{

	public List<Map<String, Object>> findGroupByUserType();
	
}
