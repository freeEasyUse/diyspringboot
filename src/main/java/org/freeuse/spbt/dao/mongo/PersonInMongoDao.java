package org.freeuse.spbt.dao.mongo;

import org.freeuse.spbt.jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * 使用mongoTemplate 进行 mongodb 处理
 * @author GeL
 *
 */
@Component
public class PersonInMongoDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 新增
	 * @param person
	 */
	public void insertPerson(Person person){
		mongoTemplate.save(person);
	}
	
	
	public Person seachByName(String name){
		Query query = new Query();
		query.addCriteria(new Criteria("name").is("test"));
		return mongoTemplate.findOne(query, Person.class);
	}
	
	
}
