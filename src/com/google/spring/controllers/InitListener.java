package com.google.spring.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.google.jpa.datamodel.User;
import com.google.jpa.datamodel.UserRoles;
import com.google.spring.services.UserDao;

@Component
public class InitListener 
        implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UserDao userDao;
  
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	ApplicationContext context = event.getApplicationContext();
        System.out.println(context.getDisplayName());
        
        
    }
}