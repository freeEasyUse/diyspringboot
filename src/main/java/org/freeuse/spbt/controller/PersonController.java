package org.freeuse.spbt.controller;

import java.util.List;

import org.freeuse.spbt.jpa.dao.PersonRepository;
import org.freeuse.spbt.jpa.entity.Person;
import org.freeuse.spbt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/person")
@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	
	@Autowired
	private PersonService personService;
	
	/**
	 * 保存 
	 * save 支持批量保存 <s extends T > Iterable<s> save（Iterable<s> entities）；
	 * 
	 * 删除
	 * 支持使用id删除 批量删除 以及全部删除
	 * void delete(ID id);
	 * void delete(T entity);
	 * void delete(Iterable<? extends T> entities);
	 * void deleteAll()
	 * 
	 */
	
	@RequestMapping("/save")
	public Person save(String name,String address,Integer age){
			Person p = personRepository.save(new Person(null,name,address,age));
			return p;
	}
	
	
	@RequestMapping("query1")
	public List<Person> query1(String address){
		List<Person> people = personRepository.findByAddress(address);
		return people;
	}
	
	
	@RequestMapping("query2")
	public Person query2(String name,String address){
		Person person = personRepository.findByNameAndAddress(name, address);
		return person;
	}
	
	
	
	@RequestMapping("query3")
	public Person query3(String name,String address){
		Person person = personRepository.withNameAndAddressQuery(name, address);
		return person;
	}
	
	
	@RequestMapping("query4")
	public Person query4(String name,String address){
		Person person = personRepository.withNameAndAddressNameQuery(name, address);
		return person;
	}
	
	
	/**
	 * 测试排序
	 * @return
	 */
	@RequestMapping("/sort")
	public List<Person> sort(){
		List<Person> people = personRepository.findAll(new Sort(Direction.ASC, "age"));
		return people;
	}
	
	
	
	/**
	 * 测试分页
	 * @return
	 */
	@RequestMapping("/page")
	public Page<Person> page(){
		Page<Person> peoplePage = personRepository.findAll(new PageRequest(1, 2));
		return peoplePage;
	}
	
	
	
	@RequestMapping("/rollback")
	public Person rollback(Person person){
		return personService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/norollback")
	public Person norollback(Person person){
		return personService.savePersonWithoutRollBack(person);
	}
	
	
}
