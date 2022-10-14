package com.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.model.Author;
import com.bookservice.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author save(Author author) {
		return authorRepository.save(author);
	}
	
	public Author findByUsername(String username) {
		return authorRepository.findByUsername(username);
	}
	
}
