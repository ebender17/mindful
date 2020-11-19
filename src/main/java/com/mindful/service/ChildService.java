package com.mindful.service;

import java.util.List;

import com.mindful.dto.Child;

public interface ChildService {
	
	public List<Child> findAll(); 
	
	public Child findById(int theId);
	
	public void save(Child theChild); 
	
	public void deleteById(int theId); 

}
