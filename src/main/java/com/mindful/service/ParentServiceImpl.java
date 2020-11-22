package com.mindful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindful.dao.ParentRepository;
import com.mindful.dto.Parent;

@Service
public class ParentServiceImpl implements ParentService {
	
	public ParentRepository parentRepository;
	
	@Autowired 
	public ParentServiceImpl(ParentRepository theParentRepository) {
		parentRepository = theParentRepository;
	}

	@Override
	public List<Parent> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * The findById() method takes the parents identity column of the parent and searches based on the unique value.
	 * If that id is present it returns the appropriate and corresponding parent.
	 * If it does not match the if statement throws an error saying the parent id they are searching for is invalid.
	 */
	@Override
	public Parent findById(int theId) {
		Optional<Parent> parentid = parentRepository.findById(theId);
		
		Parent theParent = null;
		
		if(parentid.isPresent())
		{
			theParent = parentid.get();
		}
		else 
		{
			throw new RuntimeException("The ParentId you have entered is invalid - " + theId);
		}
		return theParent;
	}

	/*
	 * The save() method takes in new parent data and saves it to the backend database.
	 */
	@Override
	public void save(Parent theParent) {
		parentRepository.save(theParent);

	}

	/*
	 * If the id of a particular parent is selected it checks the id to the database and then deletes it accordingly.
	 */
	@Override
	public void deleteById(int theId) {
		parentRepository.deleteById(theId);

	}

}
