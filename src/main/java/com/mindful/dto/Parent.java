package com.mindful.dto;

import org.springframework.stereotype.Component;

@Component 
public class Parent {
	private int ID; 
	private String name; 
	private int childID;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getChildID() {
		return childID;
	}
	
	public void setChildID(int childID) {
		this.childID = childID;
	} 

}
