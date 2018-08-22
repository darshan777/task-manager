package com.me.taskManager.taskManager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.me.taskManager.taskManager.pojo.Issue;
import com.me.taskManager.taskManager.pojo.User;
import com.me.taskManager.taskManager.repository.IssueRepository;
import com.me.taskManager.taskManager.repository.UserRepository;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	IssueRepository issueRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//Get all Issues
	
	@GetMapping("/issues/{id}")
	public List<Issue> getAllIssues(@PathVariable(value = "id") Integer userId, Pageable pageable) {
		List<Issue> issueList = new ArrayList<Issue>();
		List<Issue> issue = issueRepository.findAll();
		for(Issue i: issue) {
			int user_id = i.getUser().getUserId();
			if(user_id == userId) {
				issueList.add(i);
			}
			
		}
		return issueList;
		
	}
	
	

	
    //Create an Issue
    @RequestMapping(value ="/issues/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Issue createIssue(@PathVariable(value="id") Integer userId,   @Valid @RequestBody Issue issue) {
    	Optional<User> u = userRepository.findById(userId);
    	if(u.isPresent()) {
    		Issue i = new Issue();
    		i.setIssueId(issue.getIssueId());
    		i.setIssueName(issue.getIssueName());
    		i.setIssueStatus(issue.getIssueStatus());
    		i.setPriority(issue.getPriority());
    		i.setUser(u.get());
    		issueRepository.save(i);
    		
    		return i;
    	}
    	else {
    		return null;
    	}
    }
    
  //Get a specific user
  /*  @GetMapping("/issues/{id}")
    public Issue getIssueById(@PathVariable(value = "id") Integer issueId) {
    	Optional<Issue> issue = issueRepository.findById(issueId);
    	if (issue.isPresent()) {
    	    return issue.get();
    	} else {
    	    return null;
    	}
         
                
    }*/
    
    //Update a specific Issue
    @PutMapping("/issues/{id}")
    public Issue updateIssue(@PathVariable(value = "id") Integer issueId,
                                            @Valid @RequestBody Issue issueDetails) {
    	
    	Optional<Issue> issue = issueRepository.findById(issueId);
    	if (issue.isPresent()) {
    		issue.get().setIssueId(issueDetails.getIssueId());
    		issue.get().setIssueName(issueDetails.getIssueName());
    		issue.get().setPriority(issueDetails.getPriority());
    		issue.get().setIssueStatus(issueDetails.getIssueStatus());
    		return issue.get();
    	}
    	else {
    		return null;
    	}
}
    
    //Delete a Issue
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteIssue(@PathVariable(value = "id") Integer issueId) {
    	Optional<Issue> issue = issueRepository.findById(issueId);
    	
    	if (issue.isPresent()) {
    		issueRepository.delete(issue.get());
    	}
    	return ResponseEntity.ok().build();
    }
    
    
}
