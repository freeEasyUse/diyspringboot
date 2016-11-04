package org.freeuse.spbt.jpa.dao;


import java.util.List;
import java.util.concurrent.Future;

import org.freeuse.spbt.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;


public interface PersonRepository extends JpaRepository<Person,Long>{

	/**
	 * 异步查询
	 * @param address
	 * @return
	 */
	@Async
	Future<List<Person>> findByAddress(String address);
	
	
	Person findByNameAndAddress(String name,String address);
	
	@Query("select p from Person p where p.name = :name and p.address = :address")
	Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
	
	//Person withNameAndAddressNameQuery(String name,String address);
	
}
