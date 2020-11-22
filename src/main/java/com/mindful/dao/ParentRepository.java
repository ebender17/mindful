package com.mindful.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindful.dto.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer> {

	public List<Parent> findAllByOrderByLastNameAsc();
	
}
