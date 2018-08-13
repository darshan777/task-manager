package com.me.taskManager.taskManager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
	

}
