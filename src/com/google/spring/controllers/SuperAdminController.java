package com.google.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.jpa.datamodel.Customer;
import com.google.spring.services.CustomerDao;
import com.google.spring.services.UserDao;

@RestController
@RequestMapping("/superadmin")
public class SuperAdminController {

		@Autowired
		UserDao userDao;
		@Autowired
		CustomerDao customerDao;
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/newcustomer",method=RequestMethod.POST)
		public Response newcustomer(@RequestBody Customer ccc) {
			String tag="Error";
			
			
			customerDao.persists(ccc);
			tag="OK";
				
			
	    	return new Response<Customer>(tag, ccc);
	    }
		

	
}
