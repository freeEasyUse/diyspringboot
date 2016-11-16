package org.freeuse.spbt.service;

import org.freeuse.spbt.jpa.entity.Person;

public interface PersonService {
	public Person savePersonWithRollBack(Person person);
	
	public Person savePersonWithoutRollBack(Person person);
	
	
	
}
