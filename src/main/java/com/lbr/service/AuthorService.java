package com.lbr.service;

import java.util.List;

import com.lbr.entity.Author;
import com.lbr.repository.AuthorRepository;

public class AuthorService {
	
	private final AuthorRepository repo;
	
	public AuthorService(AuthorRepository repo) {
		this.repo = repo;
	}

	public List<Author> getAllAuthor(){
		return repo.findAll();
	}
	
	public Author getAuthorById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
	}
	
	public Author saveAuthor(Author author) {
		return repo.save(author);
	}
	
	public Author updateAuthor(Integer id, Author authorDetails) {
		Author author = getAuthorById(id);
		author.setName(authorDetails.getName());
		author.setBio(authorDetails.getBio());
		return repo.save(author);	
	}
	
	public void deleteAuthor(Integer id) {
		repo.deleteById(id);
	}
}
