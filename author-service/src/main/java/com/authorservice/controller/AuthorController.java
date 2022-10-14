package com.authorservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.authorservice.clients.BookServiceClient;
import com.authorservice.model.Author;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/digitalbooks")
public class AuthorController {

	@Autowired
	private BookServiceClient bookServiceClient;
	
	@GetMapping("/books")
	public List<Author> getBooksFromDb(){
		return bookServiceClient.getBooks();
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		bookServiceClient.uploadImage(file);
	}
	
	@PostMapping("/books")
	public void createBook(@RequestBody Author author) throws IOException {
		bookServiceClient.createBook(author);
	}
	
	@PutMapping("/books")
	public void updateBook(@RequestBody Author author) {
		bookServiceClient.updateBook(author);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") Integer id) {
		bookServiceClient.deleteBook(id);
	}
	
}
