package com.google.spring.security;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.jpa.datamodel.User;
import com.google.jpa.datamodel.UserRoles;
import com.google.spring.services.UserDao;
 
@Service("userDetailsService")
public class TAUserDetailsService implements UserDetailsService {
 
	//get user from the database, via Hibernate
	@Autowired
	UserDao userHome;
 
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
 
		User user = userHome.findByUserId((String) username);
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getUserRoleses());
 
		return buildUserForAuthentication(user, authorities);
 
	}
 
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, 
		List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPasswd(), 
			user.isEnabled(), true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(Set<UserRoles> userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (UserRoles userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}
 
}