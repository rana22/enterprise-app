package com.enterprise.capitalist.model.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.enterprise.capitalist.CapitalistApplicationTests;
import com.enterprise.capitalist.model.UserProfiles;
import com.enterprise.capitalist.repository.UserProfileRepository;

@Transactional
public class UserProfrilesTest extends CapitalistApplicationTests {
	
	@Autowired
	UserProfileRepository usrProfileRepository;
	
	@Before 
	public void setUp(){
//		usrProfileRepository.evictCache();
	}
	
	@After
	public void clearAfter(){
		
	}
	
	@Test
	public void testFillAllUser(){
		List<UserProfiles> ursList = usrProfileRepository.findAll();
		
		Assert.notEmpty(ursList, "the user list is not empty!");
		
	}
	
	
}
