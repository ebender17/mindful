package com.mindful;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.mindful.dto.Parent;
import com.mindful.service.FirebaseInitializer;

@Controller
public class MindfulController {
	@Autowired
	FirebaseInitializer db; 
	
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
	
	@GetMapping("/getAllParents")
	public String getAllParents() throws InterruptedException, ExecutionException {
		//list of parents
		List<Parent> parentList = new ArrayList<Parent>();
		
		System.out.print(db);
		//retrieves parent collection
		CollectionReference parent = db.getFirebase().collection("Parent");
		//contains results of query
		ApiFuture<QuerySnapshot> querySnapshot = parent.get();
		
		//For every parent doc in querySnapshot, add to parentList 
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			Parent par = doc.toObject(Parent.class);
			parentList.add(par);
		}
		return "Parents"; 
		
	}
	
	@PostMapping("/getParent")
	public Parent getParent(@RequestParam("id") int id) {
		return new Parent(); 
	}
	
	@PostMapping("/addEmployee")
	public int addEmployee(@RequestBody Parent parent) {
		return 1; 
	}
	@RequestMapping("/welcome")
	public String welcomeScreen() {
		return "welcome";
	}

}
