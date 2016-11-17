package org.freeuse.spbt.dao.mongo;

import org.freeuse.spbt.jpa.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CityMongoRepository extends CrudRepository<City, Long>{

	Page<City> findAll(Pageable pageable);

	City findByCityNameAndCityCodeAllIgnoringCase(String cityName, String cityCode);
	
}
