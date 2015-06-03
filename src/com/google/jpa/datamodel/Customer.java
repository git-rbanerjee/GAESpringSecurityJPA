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



@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String customerId;
	
	private String customerName;

	private String customerMasterDeviceId;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<User> users=new HashSet<User>();
	
	
	
	/*public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}*/
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerMasterDeviceId() {
		return customerMasterDeviceId;
	}
	public void setCustomerMasterDeviceId(String customerMasterDeviceId) {
		this.customerMasterDeviceId = customerMasterDeviceId;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	
	
	
	
}
