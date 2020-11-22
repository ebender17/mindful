package com.mindful.service;

import java.util.List;

import com.mindful.dto.Account;
import com.mindful.dto.User;

public interface UserService {
	public List<User> findAll(); 
	
	public User findById(int theId);
	
	public void save(User theUser); 
	
	public void deleteById(int theId); 
	
	public Account login(String email, String password);
	
	public void signUp(Account parentOrChild, String accountType);
}
