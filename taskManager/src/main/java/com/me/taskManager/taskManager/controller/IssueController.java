package com.me.taskManager.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.taskManager.taskManager.pojo.Issue;
import com.me.taskManager.taskManager.pojo.User;
import com.me.taskManager.taskManager.repository.IssueRepository;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	IssueRepository issueRepository;
	
	//Get all Users
    @GetMapping("/issues")
    public List<Issue> getAllIssue() {
        return issueRepository.findAll();
    }
	
    
    
}
