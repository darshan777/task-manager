package com.me.taskManager.taskManager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.me.taskManager.taskManager.pojo.User;
import com.me.taskManager.taskManager.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
    @RequestMapping(value ="/notes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User createUser(@Valid @RequestBody User user) {
    	System.out.println("USer Created :"+ user.getUserId());
        return userRepository.save(user);
    }
    
    
    @GetMapping("/users/{id}")
    public User getNoteById(@PathVariable(value = "id") Integer userId) {
    	Optional<User> user = userRepository.findById(userId);
    	if (user.isPresent()) {
    	    return user.get();
    	} else {
    	    return null;
    	}
         
                
    }
    
    
    @PutMapping("/users/{id}")
    public User updateNote(@PathVariable(value = "id") Integer userId,
                                            @Valid @RequestBody User UserDetails) {
    	
    	Optional<User> user = userRepository.findById(userId);
    	if (user.isPresent()) {
    		user.get().setUserId(UserDetails.getUserId());
    		user.get().setUserName(UserDetails.getUserName());
    		user.get().setUserPassword(UserDetails.getUserPassword());
    		user.get().setUserEmail(UserDetails.getUserEmail());
    		return user.get();
    	}
    	else {
    		return null;
    	}
}
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer userId) {
    	Optional<User> user = userRepository.findById(userId);
    	
    	if (user.isPresent()) {
    		userRepository.delete(user.get());
    	}


        return ResponseEntity.ok().build();
    }
	

}
