package com.bookservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookservice.exception.BookException;
import com.bookservice.model.Book;
import com.bookservice.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	private byte[] bytes;

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public Book getBooksByTitle(String title) throws BookException {
		if (bookRepository.findByTitle(title) != null)
			return bookRepository.findByTitle(title);
		else
			throw new BookException("Book not found with the title : " + title);
	}

	public Book getBooksByCategory(String category) throws BookException {
		if (bookRepository.findByCategory(category) != null)
			return bookRepository.findByCategory(category);
		else
			throw new BookException("Book not found with the category : " + category);
	}

	public Book getBooksByAuthor(String author) throws BookException {
		if (bookRepository.findByAuthor(author) != null)
			return bookRepository.findByAuthor(author);
		else
			throw new BookException("Book not found with the author : " + author);
	}

	public void uploadImage(MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	public void createBook(Book book) throws IOException {
		book.setPicByte(this.bytes);
		bookRepository.save(book);
		this.bytes = null;
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

//	public List<Book> getAllBooksByUserId(@PathVariable("userId") Integer userId) {
//		return bookRepository.findBooksByUserId(userId);
//	}

//	public void addBook(@PathVariable("userId") Integer userId, @RequestBody Book bookRequest) {
//
//		List<User> users = userRepository.findAll();
//
//		for (int i = 0; i < users.size(); i++) {
//			if (users.get(i).getUser_id() == userId) {
//				Integer bookId = bookRequest.getId();
//				if (bookId != 0) {
//					List<Book> books = bookRepository.findAll();
//					for(int j=0; j<books.size(); j++) {
//						if(books.get(i).getId() == bookId) {
//							users.get(i).addBook(books.get(i));
//							userRepository.save(users.get(i));
//						}
//					}
//				}
//				users.get(i).addBook(bookRequest);
//				bookRepository.save(bookRequest);
//			}
//		}
//
////		Book book = userRepository.findById(userId).map(user -> {
////	    Integer bookId = bookRequest.getId();
////	    
////	    if (bookId != 0) {
////	      Book _book = bookRepository.findById(bookId);
////	      user.addBook(_book);
////	      userRepository.save(user);
////	    }
////	
////	    user.addBook(bookRequest);
////	    bookRepository.save(bookRequest);
////	  });
//	}

//	public List<Book> findByUserId(Integer userId) {
//		return bookRepository.findByUserId(userId);
//	}

	public Book save(Book bookRequest) {
		bookRequest.setPicByte(this.bytes);
		bookRepository.save(bookRequest);
		this.bytes = null;
		return bookRepository.save(bookRequest);
	}

//	public void deleteByUserId(Integer userId) {
//		
////		bookRepository.findBy
//		
////		List<Book> books = bookRepository.findAll();
////		
////		for (Book book : books) {
////			book.get
////		}
//		
//		bookRepository.deleteByUserId(userId);
//		
//		
//	}

}
