package com.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
//	List<User> findUsersByBookId(Integer bookId);
	User findByName(String name);
//	User findById(Integer id);
//	User findOne(Integer userId);
}
