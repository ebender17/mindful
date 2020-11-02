package com.mindful;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.mindful.dto.Parent;
import com.mindful.service.FirebaseInitializer;
import com.mindful.service.ParentService;

@Controller
public class MindfulController {
	@Autowired
	FirebaseInitializer db; 
	
	@Autowired
	ParentService parentService;
	
	
	/*
	 * Handle /index endpoint
	 *@return  
	 *
	 **/
	@RequestMapping("/index")
	public String index() { 
		return "index";
	}
	
	@RequestMapping("/")
	public String start() { 
		return "index";
	}
	
	@RequestMapping(value="/parentDashboard")
	public String parentDashboard() {
		return "parentDashboard";
	}
	
	@RequestMapping(value="/signUp")
	public String signUp() {
		return "signUp";
	}
	
	@RequestMapping(value="/studentDashboard")
	public String studentDashboard() {
		return "studentDashboard";
	}
	
	@RequestMapping(value="/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/welcome")
	public String welcomeScreen() {
		return "welcome";
	}
	
	@GetMapping("/getAllParents")
	public String getAllParents(Model allModel) throws InterruptedException, ExecutionException {
		
		//list of parents 
		List<Parent> parentList = new ArrayList<Parent>();
		List<Parent> parentList2 = new ArrayList<Parent>();
		
		parentList = parentService.getAllParents();
		Parent parent1 = parentService.getParentByID("u6MPV6TLadpZsy8Lh7bt");
		parentList2 = parentService.getParentByName("Tish Cyrus"); 
		 
		allModel.addAttribute("Parents", parentList); 
		allModel.addAttribute("Parent1", parent1);
		allModel.addAttribute("Parents2", parentList2); 
		 
		return "Parents"; 
		
	}
}
