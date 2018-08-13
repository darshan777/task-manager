package com.me.taskManager.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.taskManager.taskManager.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
