package com.readerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readerservice.exception.ReaderException;
import com.readerservice.model.Reader;
import com.readerservice.service.ReaderService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/digitalbooks")
public class ReaderController {

	@Autowired
	private ReaderService readerService;

	@GetMapping("/books")
	public List<Reader> getBooksFromDb() {
		return readerService.getBooksFromDb();
	}
	
	@GetMapping("/books/title/{title}")
	public Reader getBooksByTitle(@PathVariable("title") String title) throws ReaderException{
		return readerService.getBooksByTitle(title);
	}
	
	@GetMapping("/books/category/{category}")
	public Reader getBooksByCategory(@PathVariable("category") String category) throws ReaderException{
		return readerService.getBooksByCategory(category);
	}
	
	@GetMapping("/books/author/{author}")
	public Reader getBooksByAuthor(@PathVariable("author") String author) throws ReaderException{
		return readerService.getBooksByAuthor(author);
	}
	
}
