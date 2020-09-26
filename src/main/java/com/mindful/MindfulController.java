package com.mindful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MindfulController {
	
	@RequestMapping("/index")
	public String start() { 
		return "index";
	}

}
