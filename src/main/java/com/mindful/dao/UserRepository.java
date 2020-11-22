package com.mindful.dao;

import org.springframework.data.repository.CrudRepository;

import com.mindful.dto.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
