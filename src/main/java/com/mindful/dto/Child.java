package com.mindful.dto;

import java.util.List;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.GeoPoint;

public class Child {
	private String ID; //FirestoreDocumentId?
	private String firstName; 
	private String lastName;
	private GeoPoint location;
	private List<DocumentReference> parents;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
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
	public GeoPoint getLocation() {
		return location;
	}
	public void setLocation(GeoPoint location) {
		this.location = location;
	}
	public List<DocumentReference> getParents() {
		return parents;
	}
	public void setParents(List<DocumentReference> parents) {
		this.parents = parents;
	}
	
	
	
	
	

}
