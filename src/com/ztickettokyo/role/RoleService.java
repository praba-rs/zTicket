package com.ztickettokyo.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
	@Autowired RoleRepository repo;
	
	public void save(AppRole obj) {
		repo.save(obj);
	}
	
	public List<AppRole> listAll() {
		return (List<AppRole>) repo.findAll();
	}
	
	public AppRole get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<AppRole> search(String keyword) {
		return repo.search(keyword);
	}
}
