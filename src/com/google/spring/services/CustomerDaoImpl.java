package com.google.spring.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.jpa.datamodel.Customer;

@Service
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
    private transient EntityManager entityManager;
	
	@Override
	@Transactional
	public void persists(Customer customer) {
		entityManager.persist(customer);
		// TODO Auto-generated method stub
		
	}
	@Override
	@Transactional
	public void merge(Customer customer) {
		entityManager.merge(customer);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@Transactional
	public Customer findById(String id) {
		
		try {
			Customer instance = entityManager.find(Customer.class, id);
			
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
			
		}
	}
	

}
