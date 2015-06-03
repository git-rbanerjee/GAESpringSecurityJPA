package com.google.spring.services;

import com.google.jpa.datamodel.*;
public interface UserDao {
	
	public void persists(User user);

	public void merge(User user);
	public User findByUserId(String userId);
}
