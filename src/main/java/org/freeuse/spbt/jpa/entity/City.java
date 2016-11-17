package org.freeuse.spbt.jpa.entity;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class City {
	
	private Long id;
	
	private String cityName;
	
	private String cityCode;
	
	private String cityDes;

	public City(){
		super();
	}
	
	public City(Long id,String cityName,String cityCode,String cityDes){
		super();
		this.id = id;
		this.cityName = cityName;
		this.cityCode = cityCode;
		this.cityDes = cityDes;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityDes() {
		return cityDes;
	}

	public void setCityDes(String cityDes) {
		this.cityDes = cityDes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
