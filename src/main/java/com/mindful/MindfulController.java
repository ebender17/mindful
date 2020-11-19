package com.mindful;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindful.dto.Child;
import com.mindful.dto.Parent;
import com.mindful.service.ChildService;
import com.mindful.service.ParentService;

@Controller
public class MindfulController {
	
	public ParentService parentService;
	public ChildService childService;
	
	public MindfulController(ParentService theParentService, ChildService theChildService) 
	{
		parentService = theParentService;
		childService = theChildService;
	}
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
	
	@PostMapping("/save")
	public String save(@ModelAttribute("parent") Parent theParent) throws InterruptedException, ExecutionException {
		//System.out.println(theParent.getID());
		parentService.save(theParent);
		
		return "redirect:/signUp";
	}
	
	@GetMapping("/getAllParents")
	public String getAllParents(Model allModel) throws InterruptedException, ExecutionException {
		
		 
		return "Parents"; 
		
	}
	
	
	@RequestMapping("/addData")
	public String addData()
	{
		Parent parent1 = new Parent();
		Parent parent2 = new Parent();
		
		Child child1 = new Child();
		
		child1.setFirstName("Miley");
		child1.setLastName("Cyrus");
		
		parent1.setFirstName("Billy Ray");
		parent1.setLastName("Cyrus");
		parent2.setFirstName("Tish");
		parent2.setLastName("Cyrus");
		
		child1.getParents().add(parent1);
		child1.getParents().add(parent2);
		parent1.getChildren().add(child1);
		parent2.getChildren().add(child1); 
		
		parentService.save(parent1);
		parentService.save(parent2);
		return "redirect:/index";
	}
	
}
