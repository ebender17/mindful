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

	@Override
	public void save(Child theChild) {
		childRepository.save(theChild);

	}

	@Override
	public void deleteById(int theId) {
		childRepository.deleteById(theId);

	}

}
