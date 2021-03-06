package com.mindful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindful.dao.ParentRepository;
import com.mindful.dto.Child;
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

	@Override
	public void save(Parent theParent) {
		parentRepository.save(theParent);

	}

	@Override
	public void deleteById(int theId) {
		parentRepository.deleteById(theId);

	}
	
	public String generateCode() {
		return Long.toString(Math.round(Math.random() * 1000000));
	}
	
	@Override
	public void addChildToParent(String joinCode, Child child, Parent parent) {
		if(parent.getJoinCode().equals(joinCode)) {
			parent.getChildren().add(child);
			save(parent);
		} else {
			throw new RuntimeException("No join code with code: " + joinCode);
		}
	}

	@Override
	public Parent findByJoinCode(String code) {
		// TODO Auto-generated method stub
		return parentRepository.findByJoinCode(code);
	}

}
