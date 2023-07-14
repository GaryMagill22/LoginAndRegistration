package com.gary.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.gary.loginandregistration.models.LoginUser;
import com.gary.loginandregistration.models.User;
import com.gary.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values: 
        // Reject if email is taken (present in database)
        // 1. Find user in the DB by email   
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "This email is already registered!");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "matches", "Password and confrim password must match.");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
        // 2. if the email is present , reject
        // Reject if password doesn't match confirmation
        // if result has errors, return 
        // Hash and set password, save user to database  
      
    }
        
    
    public User login(LoginUser newLogin, BindingResult result) {
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
    	
    	if(optionalUser.isEmpty()) {
    		result.rejectValue("confirm", "unique", "This email is not registered.");
    		return null;
    	}
    	User user = optionalUser.get();
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password.");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	return user;
    }
    
    
    
    
  
}