package com.me.taskManager.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.taskManager.taskManager.pojo.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer>{

}
