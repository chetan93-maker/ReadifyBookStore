package com.lbr.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lbr.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

		Page<Book> findByGenre(String genre, Pageable pageable);
	
}
