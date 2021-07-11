package com.web.app.repo;

import java.util.List;

//import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.web.app.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	 public List<Book> findBybookName (String bookName);
	 public List<Book> deleteBybookName (String bookName);

	 
	 


	 
}
