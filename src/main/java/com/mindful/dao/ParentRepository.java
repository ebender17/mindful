package com.mindful.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindful.dto.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer> {

	/*
	 * Allowing for mindful to use an order by last name when finding parents on the webpage.
	 */
	public List<Parent> findAllByOrderByLastNameAsc();
}
