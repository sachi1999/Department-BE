package net.store.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.*;

import net.store.api.repository.UserDetailsRepository;
import net.store.api.model.LoginRequest;
import net.store.api.model.LoginResponse;
import net.store.api.model.UserDetail;

@RestController
@RequestMapping("/api/v1/Auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	@PostMapping("Login")
	public LoginResponse login(@RequestBody LoginRequest Login )
	{
		LoginResponse loginRes = new LoginResponse(); 
		
		String hashedPwd = Hashing.sha256()
		        .hashString(Login.getPwd(), StandardCharsets.UTF_8)
		        .toString();	
		
		UserDetail user =  userDetailsRepository.findByEmailIdIgnoreCase(Login.getEmailId());
		
		if (user == null)
		{
			loginRes.setStatus(404);
			loginRes.setErrMsg("Email address not found");
			return loginRes;
		}
		
		if (!hashedPwd.equals(user.getPwd()))
		{
			loginRes.setStatus(401);
			loginRes.setErrMsg("Invalid password");
			return loginRes;
		}
		
		
		loginRes.setStatus(200);
		loginRes.setErrMsg("User Found");
		loginRes.setUser(user);
	    return loginRes;
		
		
	}

}
