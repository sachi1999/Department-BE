package net.store.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.*;

import net.store.api.repository.UserDetailsRepository;
import net.store.api.model.UserDetail;

@RestController
@RequestMapping("/api/v1/Account")
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	 @GetMapping("GetUserDetails") public List<UserDetail> getAllUsers() 
	 { 
		 return userDetailsRepository.findAll(); 
	 }
	

	@PostMapping("Register")
	public UserDetail createUser(@RequestBody UserDetail user)
	{
		
		if(userDetailsRepository.findByEmailIdIgnoreCase(user.getEmailId()) != null) {
			return null;
		}
		
		String hashedPwd = Hashing.sha256()
		        .hashString(user.getPwd(), StandardCharsets.UTF_8)
		        .toString();
		user.setPwd(hashedPwd);
		return userDetailsRepository.save(user);
	}
	
}
