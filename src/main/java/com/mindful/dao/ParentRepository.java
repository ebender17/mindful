package com.mindful.dao;

import org.springframework.data.repository.CrudRepository;

import com.mindful.dto.Parent;
import com.mindful.dto.User;

public interface ParentRepository extends CrudRepository<Parent, Integer> {
	Parent findByJoinCode(String code);
}
