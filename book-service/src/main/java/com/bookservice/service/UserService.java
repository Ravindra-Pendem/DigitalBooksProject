package com.bookservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookservice.model.User;
import com.bookservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User getUsersByName(String name){
		return userRepository.findByName(name);
	}
	
	public void createUser(@RequestBody User user) throws IOException {
		userRepository.save(user);
	}
	
}
