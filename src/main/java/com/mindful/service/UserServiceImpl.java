package com.mindful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindful.dao.ChildRepository;
import com.mindful.dao.ParentRepository;
import com.mindful.dao.UserRepository;
import com.mindful.dto.Account;
import com.mindful.dto.Child;
import com.mindful.dto.Parent;
import com.mindful.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	public UserRepository userRepository;
	public ParentRepository parentRepository;
	public ChildRepository childRepository;
	
	@Autowired 
	public UserServiceImpl(UserRepository theUserRepository, ParentRepository theParentRepository, ChildRepository theChildRepository) {
		userRepository = theUserRepository;
		parentRepository = theParentRepository;
		childRepository = theChildRepository;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int theId) {
		// TODO Auto-generated method stub
		Optional<User> userID = userRepository.findById(theId);
		
		User theUser = null;
		
		if(userID.isPresent())
		{
			theUser = userID.get();
		}
		else 
		{
			throw new RuntimeException("The UserId you have entered is invalid - " + theId);
		}
		return theUser;
	}
	
	public Account login(String email, String password) {
		User user = userRepository.findByEmail(email);
		Account login = new Parent();
		
		switch(user.getAccountType()) {
			case "parent":
				login = parentRepository.findById(user.getAccountID()).get();
				break;
			case "child":
				login = childRepository.findById(user.getAccountID()).get();
				break;
		}
		
		if(!login.getPassword().equals(password)) {
			throw new RuntimeException("The password you have entered is invalid");
		}
		
		return login;
	}
	
	public void signUp(Account parentOrChild, String accountType) {
		int id = -1;
		switch(accountType) {
			case "parent":
				id = parentRepository.save((Parent) parentOrChild).getID();
				break;
			case "child":
				id = childRepository.save((Child) parentOrChild).getID();
				break;
		}
		
		User theUser = new User();
		
		theUser.setAccountID(id);
		theUser.setAccountType(accountType);
		theUser.setEmail(parentOrChild.getEmail());
		theUser.setPassword(parentOrChild.getPassword());
		
		save(theUser);
	}

	@Override
	public void save(User theUser) {
		// TODO Auto-generated method stub
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(theId);
	}
	
}
