package org.freeuse.spbt.jpa.dao.redis;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisTool {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, String> valOpsStr;
	
	
	@Resource(name = "redisTemplate")
	private ValueOperations<Object, Object> valOps;
	
	public void setValue(String key,Object value){
	}
	
}
