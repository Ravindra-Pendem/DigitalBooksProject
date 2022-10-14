package com.bookservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookservice.model.Author;
import com.bookservice.utils.PasswordEncoderDemo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AuthorService authorService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//// find user from database where user = :username
//// userRepo.findByUsername(username);// username, password, roles
//		if ("demo".equals(username)) {
//			return new User("demo",
//// "{noop}demo@123",
//					"$2a$10$.KHH/tBblriAEr8xYyAhSOah0kg.v.XaZoIZOc8wFT5urnwqMCpim", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		Author author = authorService.findByUsername(username);
		
		if(author == null) {
			throw new UsernameNotFoundException("User not found with username: " + 
					username);
		}
		return new org.springframework.security.core.userdetails.User(author.getUsername(), 
				author.getPassword(),
				new ArrayList<>());
	}
	
	public Author save(Author author) {
		Author newAuthor = new Author();
//		PasswordEncoderDemo pass = new PasswordEncoderDemo();
		
		PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		
		newAuthor.setUsername(author.getUsername());
		newAuthor.setPassword(bcryptEncoder.encode(author.getPassword()));
		
		return authorService.save(newAuthor);
	}
}
