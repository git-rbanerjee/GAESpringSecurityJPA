package com.google.spring.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.jpa.datamodel.User;
import com.google.jpa.datamodel.UserRoles;
import com.google.spring.services.UserDao;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDao userDao;

	

}
