package org.freeuse.spbt.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Person.withNameAndAddressNameQuery",query="select p from Person p where p.name = ?1 and address = ?2")
public class Person implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Integer age;
	
	private String address;
	
	public Person(Long id, String name, String address, Integer age){
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public Person(){
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
