package com.khasim.orm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.khasim.orm.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Retrieve ISBN and Author data from Book entity
    @Query("SELECT b.isbn, b.author FROM Book b")
    List<Object[]> getData();

    // Count books by a specific author
    @Query("SELECT COUNT(b) FROM Book b WHERE b.author = :author")
    int countBooksByAuthor(String author);

    // Retrieve distinct authors
    @Query("SELECT DISTINCT b.author FROM Book b")
    List<String> getDistinctAuthors();
}