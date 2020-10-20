package com.mindful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MindfulController {
	
	/*
	 * Handle /start endpoint
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
	
	@RequestMapping("/welcome")
	public String welcomeScreen() {
		return "welcome";
	}

}
