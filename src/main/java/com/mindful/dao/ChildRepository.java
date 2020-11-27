package com.mindful.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindful.dto.Child;

public interface ChildRepository extends CrudRepository<Child, Integer> {
	public List<Child> findAll();

}
