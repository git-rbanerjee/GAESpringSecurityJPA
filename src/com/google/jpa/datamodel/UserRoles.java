package com.google.jpa.datamodel;


//Generated May 13, 2015 4:17:39 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.appengine.api.datastore.Key;


@Entity
public class UserRoles implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Key userRoleId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference
	private User user;
	
	private String role;

	public UserRoles() {
	}

	public UserRoles(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public Key getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Key userRoleId) {
		this.userRoleId = userRoleId;
	}

	
	public User getuser() {
		return this.user;
	}

	public void setuser(User user) {
		this.user = user;
	}

	
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
