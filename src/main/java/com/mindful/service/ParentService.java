package com.mindful.service;

import java.util.List;

import com.mindful.dto.Parent;

public interface ParentService {
	
	public List<Parent> findAll(); 
	
	public Parent findById(int theId);
	
	public void save(Parent theParent); 
	
	public void deleteById(int theId); 

}
