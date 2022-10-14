package com.bookservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.bookservice.exception.BookException;
import com.bookservice.model.Book;
import com.bookservice.model.User;
import com.bookservice.service.BookService;
import com.bookservice.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/digitalbooks")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@GetMapping("/books/title/{title}")
	public Book getBooksByTitle(@PathVariable("title") String title) throws BookException {
		return bookService.getBooksByTitle(title);
	}

	@GetMapping("/books/category/{category}")
	public Book getBooksByCategory(@PathVariable("category") String category) throws BookException {
		return bookService.getBooksByCategory(category);
	}

	@GetMapping("/books/author/{author}")
	public Book getBooksByAuthor(@PathVariable("author") String author) throws BookException {
		return bookService.getBooksByAuthor(author);
	}

	@PostMapping("/upload")
	@PreAuthorize("isAuthenticated()")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		bookService.uploadImage(file);
	}

	@PostMapping("/books")
	@PreAuthorize("isAuthenticated()")
	public void createBook(@RequestBody Book book) throws IOException {
		bookService.createBook(book);
	}

	@PutMapping("/books")
	@PreAuthorize("isAuthenticated()")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}

	@DeleteMapping("/books/{id}")
	@PreAuthorize("isAuthenticated()")
	public void deleteBook(@PathVariable("id") Integer id) {
//		Book book = bookRepository.getOne(id);
		bookService.deleteBook(id);
//		return book;
	}

	@GetMapping("/users/{userId}/books")
	public List<Book> getAllBooksByUserId(@PathVariable("userId") Integer userId) {
		List<User> users = userService.getUsers();
		User userDetails = new User();
		
		for (User user : users) {
			if(user.getId() == userId) {
				userDetails = user;
			}
		}
		
		List<Book> books = new ArrayList<Book>();
		books.addAll(userDetails.getBooks());
		
		return books;
	}

	@PostMapping("/users/{userId}/books")
	public void createBook(@PathVariable("userId") Integer userId, @RequestBody Book bookRequest) throws IOException {
		List<User> users = userService.getUsers();
		
		for (User user : users) {
			if (user.getId() == userId) {
				user.getBooks().add(bookRequest);
				userService.createUser(user);
			}
		}
		
		
	}

	@DeleteMapping("/users/{userId}/books")
	public void deleteAllBooksOfUser(@PathVariable("userId") Integer userId,  @RequestBody Book bookRequest) {
//		List<User> users = userService.getUsers();
//		for (User user : users) {
//			if (user.getId() == userId) {
//				Set<Book> books = user.getBooks();
//				for (Book book : books) {
//					if(book.getId() == bookRequest.getId()) {
//						books.remove(book);
//					}
//				}
//			}
//			}
//		bookService.deleteByUserId(userId);
		
		List<User> users = userService.getUsers();
		User userDetails = new User();
		
		for (User user : users) {
			if(user.getId() == userId) {
				userDetails = user;
			}
		}	
		
		Set<Book> books = new HashSet<Book>();
		books.addAll(userDetails.getBooks());
	
		
		userDetails.getBooks().removeAll(books);
		
	}
	
}
