package org.freeuse.spbt.dao.mongo;

import org.freeuse.spbt.jpa.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityMongoRepository extends MongoRepository<City, Long>{

	Page<City> findAll(Pageable pageable);

	City findByCityNameAndCityCodeAllIgnoringCase(String cityName, String cityCode);
	
}
