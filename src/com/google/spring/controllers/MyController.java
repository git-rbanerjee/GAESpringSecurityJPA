package com.google.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.jpa.datamodel.Customer;
import com.google.spring.services.CustomerDao;
import com.google.spring.services.UserDao;


/*
 * {"tag":"OK","response":{"customerId":"holwaassws","customerName":"Rabin Banerjee","customerMasterDeviceId":"10120120180298170723987791","users":[{"userId":"rabin28011991"}],"rooms":[{"appliances":[{"state":"ON","dimmable":false,"dim":5}],"sensors":[{"state":"ON"}]}]}}
 * 
 */
@RestController
@RequestMapping("/test")
public class MyController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	CustomerDao customerDao;
	
 static int i=0;
	
 
 	
	
	
	
	
	
	
	@RequestMapping(value="/getdetails",method=RequestMethod.GET)
	public Customer getDetails() {
		String tag;
		Customer customer=new Customer();
				//customerDao.persists(ccc);
				customer = customerDao.findById("rabin.banerjee92");
				System.out.println(customer.getCustomerName());
			tag="OK";
			return customer;
    }
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
	return "Hello";
	}
	
	
	
}
