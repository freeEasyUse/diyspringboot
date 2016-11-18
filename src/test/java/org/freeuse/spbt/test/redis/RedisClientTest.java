package org.freeuse.spbt.test.redis;

import org.freeuse.spbt.jpa.dao.redis.RedisTool;
import org.freeuse.spbt.jpa.entity.Person;
import org.freeuse.spbt.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisClientTest extends BaseTest {

	@Autowired
	private RedisTool redisTool;
	
	
	@Test
	public void strSet(){
		redisTool.setValueWithStr("hello", "world");
	}
	
	
	@Test
	public void setTest(){
		Person p = new Person();
		p.setId((long) 1);
		p.setName("he");
		
		redisTool.setValue(p, "person");
		
		Object result = redisTool.getValue(p);
		System.out.println(result);
	}
	
	
	
	@Test
	public void getTest(){
		Person p = new Person();
		p.setId((long) 1);
		p.setName("he");
		
		Object r = redisTool.getValue(p);
		System.out.println(r);
	}
}
