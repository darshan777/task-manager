package com.me.taskManager.taskManager.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	 
	@NotBlank  
	private String userName;
	
	@NotBlank 
	private String userPassword;
	
	@NotBlank 
	private String userEmail;
	
	 
	private String userRole;
	

	

	@OneToMany(mappedBy="user")
	public List<Issue> issues = new ArrayList<Issue>();
	
	
	
	public List<Issue> add(Issue issue){
		issues.add(issue);
		return issues;
		
	}

	public User() {
		super();
	}
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
	
	
	
	

}
