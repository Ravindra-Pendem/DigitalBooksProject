package com.readerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.readerservice.clients.BookServiceClient;
import com.readerservice.exception.ReaderException;
import com.readerservice.model.Reader;

@Service
public class ReaderService {
	
	@Autowired
	private BookServiceClient bookServiceClient;

	public List<Reader> getBooksFromDb() {
		return bookServiceClient.getBooks();
	}
	
	public Reader getBooksByTitle(@PathVariable("title") String title) throws ReaderException{
		if(bookServiceClient.getBooksByTitle(title) != null)
			return bookServiceClient.getBooksByTitle(title);
		else
			throw new ReaderException("Book not found with the title : "+title);
	}
	
	public Reader getBooksByCategory(@PathVariable("category") String category) throws ReaderException{
		return bookServiceClient.getBooksByCategory(category);
	}
	
	public Reader getBooksByAuthor(@PathVariable("author") String author) throws ReaderException{
		return bookServiceClient.getBooksByAuthor(author);
	}

}
