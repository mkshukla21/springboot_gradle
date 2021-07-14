package com.web.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.model.Book;
import com.web.app.repo.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository ;
    
	
	// save data of book
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "your record is saved successfully";
		
	}
	//save multiple data
	@PostMapping("/multipleBookSave")
	public String insertBook(@RequestBody List <Book> book) {
		bookRepository.saveAll(book);
		return "your record is saved successfully";
		
	}
	@GetMapping("/getAllBook")
	public List<Book> getBook() {
		return (List<Book>) bookRepository.findAll();
	}
	@GetMapping("/getByBookId/{bookId}")
	public Optional <Book> getBook(@PathVariable("bookId") Long id) {
		return  bookRepository.findById(id);
	}
	
	//get record by name
	@GetMapping("/getByBookName/{name}")
	public List <Book> getBookByName(@PathVariable("name") String bookName) {
		return (List<Book>)  bookRepository.findBybookName(bookName);
	}
	//delete record by book name
	@DeleteMapping("/bookName/{bookname}")
	private void deleteBook(@PathVariable("bookname")String bookname)
	{
		bookRepository.deleteBybookName(bookname);
	}
	
	
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	@DeleteMapping("/book/{bookid}")  
	private void deleteBook(@PathVariable("bookid") Long bookid)   
	{  
	bookRepository.deleteById(bookid); 
	}	 
	 
	

	//creating post mapping that post the book detail in the database  
//	public String updateBook(@RequestBody Book book) {
//		bookRepository.saveOrUpdate(book);
//		return "your record is saved successfully";
//	}
	
	 
	
}
