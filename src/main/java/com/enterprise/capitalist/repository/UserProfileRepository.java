package com.enterprise.capitalist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.capitalist.model.UserProfiles;

public interface UserProfileRepository extends JpaRepository<UserProfiles, Long>{
	
	//get all the rows from table 
	List<UserProfiles> findAll();
	
	//find the user by id
	UserProfiles findById(Long Id);
	
	List<UserProfiles> findByUserName(String userName);
	
	
	//Evict all 
//	void evictCache();
}
