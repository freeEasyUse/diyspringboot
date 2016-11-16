package org.freeuse.spbt.service.imple;

import org.freeuse.spbt.jpa.dao.PersonRepository;
import org.freeuse.spbt.jpa.entity.Person;
import org.freeuse.spbt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImple implements PersonService {

	
	@Autowired
	private PersonRepository personRepository;
	
	
	/**
	 * 指定 哪些异常需要回滚
	 */
	@Override
	@Transactional(rollbackFor = {IllegalArgumentException.class},transactionManager = "jpaTransaction")
	public Person savePersonWithRollBack(Person person) {

		Person p = personRepository.save(person);
		if(person.getName().equals("王云")){
			throw new IllegalArgumentException("王云存在 数据回滚");
		}
		
		return p;
	}

	@Override
	@Transactional(noRollbackFor = {IllegalArgumentException.class},transactionManager = "jpaTransaction")
	public Person savePersonWithoutRollBack(Person person) {

		Person p = personRepository.save(person);
		if(person.getName().equals("王云")){
			throw new IllegalArgumentException("王云存在 但是不需要数据回滚");
		}
		return p;
	}

}
