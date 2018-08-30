package com.me.taskManager.taskManager.controller;

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

import com.me.taskManager.taskManager.pojo.Project;
import com.me.taskManager.taskManager.pojo.User;
import com.me.taskManager.taskManager.repository.ProjectRepository;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	//Get all Projects
    @GetMapping("/projects")
    public List<Project> getAllUser() {
        return projectRepository.findAll();
    }
    
  //Create a Project
    @RequestMapping(value ="/projects", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Project createUser(@Valid @RequestBody Project project) {
    	Project pr = new Project();
    	
    	return projectRepository.save(project);
    }
    
    //Get a specific project
    @GetMapping("/projects/{id}")
    public Project getUserById(@PathVariable(value = "id") Integer projectId) {
    	Optional<Project> project = projectRepository.findById(projectId);
    	if (project.isPresent()) {
    	    return project.get();
    	} else {
    	    return null;
    	}
    }
    
    //Update a specific Project
    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable(value = "id") Integer projectId,
                                            @Valid @RequestBody Project ProjectDetails) {
    	
    	Optional<Project> project = projectRepository.findById(projectId);
    	if (project.isPresent()) {
    		project.get().setProjectId(ProjectDetails.getProjectId());
    		project.get().setProjectName(ProjectDetails.getProjectName());
    		
    		return project.get();
    	}
    	else {
    		return null;
    	}
}
    
    //Delete a project
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable(value = "id") Integer projectId) {
    	Optional<Project> project = projectRepository.findById(projectId);
    	
    	if (project.isPresent()) {
    		projectRepository.delete(project.get());
    	}


        return ResponseEntity.ok().build();
    }
}
