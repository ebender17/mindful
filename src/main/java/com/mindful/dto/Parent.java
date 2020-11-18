package com.mindful.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.GeoPoint;

@Component 
@Entity
@Table(name="Parent")
public class Parent {
	
	@Id // Showing that this is identification column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String ID; 
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
