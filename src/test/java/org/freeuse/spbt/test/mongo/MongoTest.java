package org.freeuse.spbt.test.mongo;

import java.util.ArrayList;
import java.util.List;

import org.freeuse.spbt.dao.mongo.CityMongoRepository;
import org.freeuse.spbt.dao.mongo.PersonInMongoDao;
import org.freeuse.spbt.jpa.entity.City;
import org.freeuse.spbt.jpa.entity.Person;
import org.freeuse.spbt.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MongoTest extends BaseTest {

	/**
	 * 使用mongoTemplate
	 */
	@Autowired
	private PersonInMongoDao personInMongoDao;
	
	@Autowired
	private CityMongoRepository cityMongoRepository;
	
	
	@Test
	public void personInMongoSave(){
		Person p = new Person((long) 123,"test","henan",21);
		personInMongoDao.insertPerson(p);
	}
	
	
	@Test
	public void personSearchByName(){
		Person p = personInMongoDao.seachByName("test");
		System.out.println(p);
	}
	
	
	
	@Test
	public void repositoryInsert(){
		List<City> citys = new ArrayList<City>();
		for(int i = 0;i<10;i++){
			citys.add(new City((long) i,i+"citys",i+"citys",i+"citys"));
		}
		cityMongoRepository.save(citys);
	}
	
	
	@Test
	public void repositorySearch(){
		City result = cityMongoRepository.findByCityNameAndCityCodeAllIgnoringCase("0citys","0citys");
		System.out.println(result);
	}
	
}
