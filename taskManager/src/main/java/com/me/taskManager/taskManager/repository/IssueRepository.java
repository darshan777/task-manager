package com.me.taskManager.taskManager.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.me.taskManager.taskManager.pojo.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer>{
}
