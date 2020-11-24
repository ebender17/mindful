package com.mindful.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.GeoPoint;


@Entity
@Table(name="Parent")
public class Parent implements Account{
	
	@Id // Showing that this is identification column
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="parentId")
	private int parentId; 
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(cascade= {
			CascadeType.ALL
	})
	@JoinTable(
			name = "parents_children",
			joinColumns = {
					@JoinColumn(name = "parentId")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "childId")
			}
			)
	private Set<Child> children = new HashSet<Child>();

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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


	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return getParentId();
	}
	
	@Override
	public String getAccountType() {
		return "parent";
	}


}
