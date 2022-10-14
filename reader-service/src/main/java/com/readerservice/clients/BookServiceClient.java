package com.readerservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.readerservice.model.Reader;

@FeignClient("BOOK-SERVICE")
//@FeignClient("http://localhost:8081/api/v1/digitalbooks")
public interface BookServiceClient {
	
	@GetMapping("/api/v1/digitalbooks/books")
	List<Reader> getBooks();
	
	@GetMapping("/api/v1/digitalbooks/books/title/{title}")
	Reader getBooksByTitle(@PathVariable("title") String title);
	
	@GetMapping("/api/v1/digitalbooks/books/category/{category}")
	Reader getBooksByCategory(@PathVariable("category") String category);
	
	@GetMapping("/api/v1/digitalbooks/books/author/{author}")
    Reader getBooksByAuthor(@PathVariable("author") String author);
}
