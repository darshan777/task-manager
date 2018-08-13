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
@Table(name = "project")
@EntityListeners(AuditingEntityListener.class)
public class Project {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	 
	@NotBlank 
	private String projectName;
	
	@OneToMany(mappedBy="project")
	private List<Issue> issueList = new ArrayList<Issue>();
	
	
	
	

	public Project() {
		super();
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Issue> getIssueList() {
		return issueList;
	}

	public void setIssueList(List<Issue> issueList) {
		this.issueList = issueList;
	}
	
	
	
	
	

}
