package com.lbr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.lbr.entity.Book;
import com.lbr.repository.BookRepository;

public class BookService {

	private final BookRepository repo;
	
	public BookService(BookRepository repo) {
	       this.repo = repo;
	}
	
	public Page<Book> getAllBooks(int page, int size, String sortBy){
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return repo.findAll(pageable);
	}
	
	public Page<Book> getBookByGenre(String genre, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repo.findByGenre(genre, pageable);
	}
	
	public Book getBookById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
	}
	
	public Book saveBook(Book book) {
		return repo.save(book);
	}
	
	public Book updateBook(Long id, Book bookDetails) {
		Book book = getBookById(id);
		book.setTitle(bookDetails.getTitle());
		book.setGenre(bookDetails.getGenre());
		book.setPrice(bookDetails.getPrice());
		return repo.save(book);
	}
	
	public void deleteBook(Long id) {
		repo.deleteById(id);
	}
}
