package com.bookservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.model.User;
import com.bookservice.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/digitalbooks")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/name/{name}")
	public User getUsersByName(@PathVariable("name") String name) {
		return userService.getUsersByName(name);
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) throws IOException {
		userService.createUser(user);
	}

}
