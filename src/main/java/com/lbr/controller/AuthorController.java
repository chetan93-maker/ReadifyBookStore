package com.lbr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbr.entity.Author;
import com.lbr.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	private final AuthorService service;
	
	public AuthorController(AuthorService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Author> getAllAuthors(){
		return service.getAllAuthor();
	}
	
	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable Integer id) {
		return service.getAuthorById(id);
	}
	
	@PutMapping("/{id}")
	public Author updateAuthor(@PathVariable Integer id, @RequestParam Author author) {
		return service.updateAuthor(id, author);
	}
	
	@DeleteMapping("/{id}")
    public void deleteAuthor(Integer id) {
    	service.deleteAuthor(id);
    }
}
