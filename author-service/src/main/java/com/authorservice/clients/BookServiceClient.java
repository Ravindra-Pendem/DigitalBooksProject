package com.authorservice.clients;

import java.io.IOException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.authorservice.model.Author;

@FeignClient("BOOK-SERVICE")
//@FeignClient("http://localhost:8081/api/v1/digitalbooks")
public interface BookServiceClient {
	
	@GetMapping("/api/v1/digitalbooks/books")
	List<Author> getBooks();
	
	@PostMapping("/api/v1/digitalbooks/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException;

	@PostMapping("/api/v1/digitalbooks/books")
	public void createBook(@RequestBody Author author) throws IOException;
	
	@PutMapping("/api/v1/digitalbooks/books")
	public void updateBook(@RequestBody Author author);
	
	@DeleteMapping("/api/v1/digitalbooks/books/{id}")
	public void deleteBook(@PathVariable("id") Integer id);
	
}
