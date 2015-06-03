package com.google.spring.services;
import com.google.jpa.datamodel.*;

public interface CustomerDao {
	
	public void persists(Customer customer);
	public Customer findById(String id);
	public void merge(Customer customer);

}
