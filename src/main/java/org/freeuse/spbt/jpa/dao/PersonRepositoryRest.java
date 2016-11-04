package org.freeuse.spbt.jpa.dao;

import java.util.List;

import org.freeuse.spbt.jpa.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepositoryRest extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByName(@Param("name") String name);
	
}
