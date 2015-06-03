package com.google.jpa.datamodel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.appengine.api.datastore.Key;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Key key;
	
	private String userId;
	
	private String passwd;

	private String deviceId;
	
	private boolean enabled=true;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user",fetch = FetchType.EAGER)
	private Set<UserRoles> userRoleses = new HashSet<UserRoles>(0);
	
	
	private String customerId; 
	
	
	
	public User() {
		super();
	}
	public User(String userId, String passwd, String deviceId) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.deviceId = deviceId;
	}
	
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<UserRoles> getUserRoleses() {
		return userRoleses;
	}
	public void setUserRoleses(Set<UserRoles> userRoleses) {
		this.userRoleses = userRoleses;
	}
	
	
	

}
