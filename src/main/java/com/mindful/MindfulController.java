package com.mindful;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindful.dto.Account;
import com.mindful.dto.Child;
import com.mindful.dto.Parent;
import com.mindful.dto.User;
import com.mindful.service.ChildService;
import com.mindful.service.ParentService;
import com.mindful.service.UserService;

@Controller
public class MindfulController {
	
	public ParentService parentService;
	public ChildService childService;
	public UserService userService;
	
	public MindfulController(ParentService theParentService, ChildService theChildService, UserService theUserService) 
	{
		parentService = theParentService;
		childService = theChildService;
		userService = theUserService;
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
	
	@RequestMapping("/connectToParent")
	public String connect() {
		return "connectToParent";
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
	public String signUp(Model theModel) {
		Parent parent = new Parent();
		theModel.addAttribute("parent", parent);
		return "signUp";
	}
	
	@RequestMapping(value="/login")
	public String login(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "redirect:/index?logout=true";
	} 
	
	@RequestMapping(value="/studentDashboard")
	public String studentDashboard(Model theModel, @RequestParam("childID") int childID) {
		Child theChild = childService.findById(childID);
		theModel.addAttribute("child", theChild);
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
	
//	@GetMapping("/")
//	public String displayParent(Model theModel) {
//		theModel.addAttribute("parent", new Parent());
//		return "parent";
//	}
	
	@GetMapping("/join")
	public String join(@RequestParam("joinCode") String code, @RequestParam("childID") int childID){
		Child child = childService.findById(childID);
		Parent parent = parentService.findByJoinCode(code);
		System.out.print(parent.getJoinCode());
		parentService.addChildToParent(code, child, parent);
		return "redirect:/index";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User theUser) {
		Account user = userService.login(theUser.getEmail(), theUser.getPassword());
		//userService.login(theUser.getEmail(), theUser.getPassword());
		//System.out.println(userService.login(theUser.getEmail(), theUser.getPassword()));
		if(user.getAccountType().equals("parent")) {
			Parent parent = new Parent();
			parent = parentService.findById(user.getID());
			String joinCode = parent.getJoinCode();
			return  "redirect:/index?AccountId=" + user.getID() + "&AccountType=" + user.getAccountType() + "&JoinCode=" + joinCode;
		} else {
			return "redirect:/index?AccountId=" + user.getID() + "&AccountType=" + user.getAccountType();
		}	
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("parent") Parent theParent, BindingResult bindingResult, Model model) throws InterruptedException, ExecutionException {
		if(bindingResult.hasErrors()) {
			System.out.println("There was an error " + bindingResult);
			return "index";
		}
		//System.out.println(theParent.getType().equals("child"));
		model.addAttribute("parent", theParent);
		if(theParent.getType().equals("child")) {
			Child child = new Child();
			child.setFirstName(theParent.getFirstName());
			child.setLastName(theParent.getLastName());
			child.setEmail(theParent.getEmail());
			child.setPassword(theParent.getPassword());
			child.setType(theParent.getType());
			userService.signUp(child, "child");
			System.out.println(theParent.getType());
		} else {
			System.out.println(theParent.getType());
			theParent.setJoinCode(parentService.generateCode());
			userService.signUp(theParent, theParent.getType());
		}
		
		
		//parentService.save(theParent);
		
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
		child1.setEmail("miley@cyrus.com");
		child1.setPassword("abc123");
		
		parent1.setFirstName("Billy Ray");
		parent1.setLastName("Cyrus");
		parent1.setEmail("billy@cyrus.com");
		parent1.setPassword("abc123");
		parent2.setFirstName("Tish");
		parent2.setLastName("Cyrus");
		parent2.setEmail("tish@cyrus.com");
		parent2.setPassword("abc123");
		
		child1.getParents().add(parent1);
		child1.getParents().add(parent2);
		parent1.getChildren().add(child1);
		parent2.getChildren().add(child1); 
		
		userService.signUp(parent1, "parent");
		userService.signUp(parent2, "parent");
		userService.signUp(child1, "child");
		
		return "redirect:/index";
	}
	
	@PostMapping("/studentDashboard")
	public String saveLongSatChild(@ModelAttribute("child") 
	Child theChild) {
		Child child = childService.findById(theChild.getChildId());
		child.setLatitude(theChild.getLatitude());
		child.setLongitude(theChild.getLongitude());
		childService.save(child);
		
		return "/studentDashboard";
	}
	
	@GetMapping("/parentDashboard")
	public String listOfLocations(Model theModel, @RequestParam("parentID") int parentID) {
		Set<Child> theChild = parentService.findById(parentID).getChildren();
		
		theModel.addAttribute("children", theChild);
		
		return "/parentDashboard";
				
	}
	
}
