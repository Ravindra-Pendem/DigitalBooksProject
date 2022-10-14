package com.bookservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookservice.model.Author;

public interface AuthorRepository extends CrudRepository<Author, String> {

	Author findByUsername(String username);
}
