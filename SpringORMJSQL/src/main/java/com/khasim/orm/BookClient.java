package com.khasim.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khasim.orm.repository.BookRepository;

@Component
public class BookClient implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Call the methods of BookRepository here
        List<Object[]> bookData = bookRepository.getData();
        for (Object[] data : bookData) {
            int isbn = (int) data[0];
            String author = (String) data[1];
            System.out.println("ISBN: " + isbn + ", Author: " + author);
        }

        // Replace "Author Name" with an actual author name
        String authorName = "Author Name";
        int bookCount = bookRepository.countBooksByAuthor(authorName);
        System.out.println("Number of books by " + authorName + ": " + bookCount);

        List<String> distinctAuthors = bookRepository.getDistinctAuthors();
        System.out.println("Distinct Authors: " + distinctAuthors);
    }
}