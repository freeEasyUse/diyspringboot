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
	
	/**
	 * set by strRedisTemplate
	 * @param key
	 * @param value
	 */
	public void setValueWithStr(String key,String value){
		valOpsStr.set(key, value);
	}
	
	/**
	 * get by strRedisTemplate
	 * @param key
	 * @return
	 */
	public String getValueWithStr(String key){
		return valOpsStr.get(key);
	}
	
	/**
	 * set by redisTemplate
	 * @param key
	 * @param value
	 * key 和 value 需要实现序列化
	 */
	public void setValue(Object key,Object value){
		valOps.set(key, value);
	}
	
	/**
	 * get by redisTemplate
	 * @param key
	 * @return
	 */
	public Object getValue(Object key){
		return valOps.get(key);
	}
}
