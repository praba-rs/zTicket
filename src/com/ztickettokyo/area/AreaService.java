package com.ztickettokyo.area;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AreaService {
	@Autowired AreaRepository repo;
	
	public void save(Area obj) {
		repo.save(obj);
	}
	
	public List<Area> listAll() {
		return (List<Area>) repo.findAll();
	}
	
	public Area get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Area> search(String keyword) {
		return repo.search(keyword);
	}
}
