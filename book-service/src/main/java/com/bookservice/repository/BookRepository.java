package com.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByTitle(String title);
	Book findByCategory(String category);
	Book findByAuthor(String author);
//	List<Book> findByUserId(Integer userId);
//	
//	@Transactional
//	@Modifying
//	@Query("DELETE FROM Book b WHERE b.user_id = :user_id")
//	void deleteByUserId(@Param("user_id") Integer user_id);
	
}
