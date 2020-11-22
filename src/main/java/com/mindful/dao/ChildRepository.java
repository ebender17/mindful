package com.mindful.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindful.dto.Child;

public interface ChildRepository extends CrudRepository<Child, Integer> {

	/*
	 * Allowing for mindful to show children ordered by last name if they want to implement.
	 */
	public List<Child> findAllByOrderByLastNameAsc();
}
