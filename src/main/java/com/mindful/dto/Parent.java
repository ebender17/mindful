package com.mindful.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.GeoPoint;

@Component 
public class Parent {
	private String ID; 
	private String firstName;
	private String lastName;
	private GeoPoint location;
	private double latitude;
	private double longitude;
	private List<String> children;

	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
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
		this.longitude = location.getLongitude(); 
		this.latitude = location.getLatitude();
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public List<String> getChildren() {
		return children;
	}
	public void setChildren(List<String> children) {
		this.children = children;
	}

}
