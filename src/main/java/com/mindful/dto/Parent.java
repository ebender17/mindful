package com.mindful.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component 
public class Parent {
	private int ID; 
	private String firstName;
	private String lastName;
	// private ArrayList<Child> children;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*public ArrayList<Child> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	} */
	

}
