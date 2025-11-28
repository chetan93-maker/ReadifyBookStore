package com.lbr.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbr.entity.Book;
import com.lbr.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookService service;
	
	
	public BookController(BookService service) {
		this.service = service;
	}


	@GetMapping
	public Page<Book> getAllBooks(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
				return service.getAllBooks(page, size, sortBy);
			}
			
	@GetMapping("/genre/{genre}")
	public Page<Book> getBookByGenre(
			@PathVariable String genre,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		return service.getBookByGenre(genre, page, size);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return service.getBookById(id);
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
		return service.updateBook(id, book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		service.deleteBook(id);
	}
}
