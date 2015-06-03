package com.google.spring.services;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.jpa.datamodel.Customer;
import com.google.jpa.datamodel.User;

@Service
public class UserDaoImpl implements UserDao {

	@PersistenceContext
    private transient EntityManager entityManager;
	
	@Override
	@Transactional
	public void persists(User user) {
		
		
			entityManager.persist(user);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	@Transactional
	public void merge(User user) {
		entityManager.merge(user);
		// TODO Auto-generated method stub
		
	}
	@Override
	@Transactional
	public User findByUserId(String userId) {

		try {
			Query query1 = entityManager.createQuery("Select u from User u where userId=:userId");
			query1.setParameter("userId", userId);
			User user=((List<User>)query1.getResultList()).get(0);
			
			return user;
		} catch (RuntimeException re) {
			
			return null;
		}
	}
	

}
