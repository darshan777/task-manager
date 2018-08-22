package com.me.taskManager.taskManager.pojo;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "issues")
@EntityListeners(AuditingEntityListener.class)
public class Issue {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issueId;
	 
	@NotNull
	private String issueName;
	
	
	private String Priority;
	
	@NotNull
	private int issueStatus;
	
	@ManyToOne
    @JoinColumn(name="projectId", nullable=true)
	private Project project;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="userId", nullable=false)
	private User user;
	
	
	
	
	
	
	public Project getProject() {
		return project;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Issue( String issueName, String priority, int issueStatus) {
		super();
		
		this.issueName = issueName;
		this.Priority = priority;
		this.issueStatus = issueStatus;
	}
	public Issue() {
		super();
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getIssueName() {
		return issueName;
	}
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public int getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(int issueStatus) {
		this.issueStatus = issueStatus;
	}
	
	
	

}
