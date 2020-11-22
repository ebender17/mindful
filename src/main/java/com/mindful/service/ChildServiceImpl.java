package com.mindful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindful.dao.ChildRepository;
import com.mindful.dto.Child;

@Service
public class ChildServiceImpl implements ChildService {
	
	public ChildRepository childRepository;
	
	@Autowired
	public ChildServiceImpl(ChildRepository theChildRepository)
	{
		childRepository = theChildRepository; 
	}

	@Override
	public List<Child> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * The findById() method takes the child id and if it is present it will get the child corresponding to the identifier.
	 * If the id is not found then it throws an error saying the child id is not present.
	 * Finally the child is returned if the corresponding identifier is present.
	 */
	@Override
	public Child findById(int theId) {
		Optional<Child> childid = childRepository.findById(theId);
		
		Child theChild = null; 
		
		if(childid.isPresent())
		{
			theChild = childid.get();
		}
		else 
		{
			throw new RuntimeException("The ChildId you have entered is invalid - " + theId);
		}
		return theChild;
	}

	/*
	 * The save() method takes new child information and saves it to the database while also giving it a new identifier so it can be returned later.
	 */
	@Override
	public void save(Child theChild) {
		childRepository.save(theChild);

	}

	/*
	 * The deleteById() method finds the id of the corresponding child wanting to be deleted.
	 * If this id is found then it deletes the corresponding id from the database.
	 */
	@Override
	public void deleteById(int theId) {
		childRepository.deleteById(theId);

	}

}
