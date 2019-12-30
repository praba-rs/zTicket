package com.ztickettokyo.role;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<AppRole, Long> {
	
	@Query(value = "SELECT c FROM AppRole c WHERE c.name LIKE '%' || :keyword || '%'")
	public List<AppRole> search(@Param("keyword") String keyword);
}
