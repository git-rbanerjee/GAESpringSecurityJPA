package com.google.spring.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.jpa.datamodel.Customer;
import com.google.jpa.datamodel.User;
import com.google.jpa.datamodel.UserRoles;
import com.google.spring.services.CustomerDao;
import com.google.spring.services.UserDao;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	UserDao userDao;
	@Autowired
	CustomerDao customerDao;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public Response adduser(@RequestBody User user) {
		String tag="Error";
		if(userDao.findByUserId(user.getUserId())==null){
		Customer customer= customerDao.findById(user.getCustomerId());
		Set<User> existingusers= customer.getUsers();
		existingusers.add(user);
		customer.setUsers(existingusers);
		UserRoles userRole = new UserRoles(user, "ROLE_USER");
		Set<UserRoles> userroles= new HashSet<UserRoles>();
		userroles.add(userRole);
		user.setUserRoleses(userroles);
		userDao.persists(user);	
		customerDao.merge(customer);
		tag="OK";
		}
		else
		{
			tag="AlreadyExist";
		}
		
    	return new Response<User>(tag, user);
    }

	
}
