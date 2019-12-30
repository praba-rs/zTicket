package com.ztickettokyo.area;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AreaRepository extends CrudRepository<Area, Long> {
	
	@Query(value = "SELECT c FROM Area c WHERE c.name LIKE '%' || :keyword || '%'")
	public List<Area> search(@Param("keyword") String keyword);
}
