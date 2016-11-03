package org.freeuse.spbt.test.respository;

import java.util.List;

import org.freeuse.spbt.jpa.dao.PersonRepository;
import org.freeuse.spbt.jpa.entity.Person;
import org.freeuse.spbt.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDaoTest extends BaseTest {

	@Autowired
	private PersonRepository personRepository;
	
	
	@Test
	public void findByNameTest(){
		List<Person> people = personRepository.findAll();
		System.out.println(people);
	}
	
}
