/**
 * @Author used for adding and removing user preference
 *
 */
package com.enterprise.capitalist.restful.user;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.enterprise.capitalist.model.UserProfiles;
import com.enterprise.capitalist.repository.UserProfileRepository;

/**
 * @author ambarrana - add/edit/delete all the business transcations 
 *
 */

@RestController
public class UserPreference {
	
	private static final Logger logger = LoggerFactory.getLogger(UserPreference.class);
	
	
	@Inject
	UserProfileRepository ursProRespository;
	
	@RequestMapping(value="/{lob}/getAllTransanctions", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public List<UserProfiles> getAllUser(@PathVariable("lob") String lob){
		logger.info("request for lob = "+ lob);
		List<UserProfiles> allUsers = ursProRespository.findAll();
		return allUsers;
	}
	
	@RequestMapping(value="/add/user", method = RequestMethod.POST)
	public ResponseEntity<UserProfiles> addUser(@RequestBody UserProfiles ursProfile){
//		ursProRespository.save(ursProfile);
		logger.info("add user " +ursProfile.getUserName());
		List<UserProfiles> existedProfile = ursProRespository.findByUserName(ursProfile.getUserName());

//		logger.info(existedProfile.get(0).getFirstName() + " row size = " + existedProfile.size());
		if(existedProfile.size() == 0){
			ursProRespository.save(ursProfile);
			logger.info("the profile with userName " + ursProfile.getUserName() + " is added.");
		}else{
			logger.info("the user profile is already exist");
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<UserProfiles>(headers, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<UserProfiles>(ursProfile, HttpStatus.CREATED);
	}
	
	

}
