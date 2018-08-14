package com.me.taskManager.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.taskManager.taskManager.pojo.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
