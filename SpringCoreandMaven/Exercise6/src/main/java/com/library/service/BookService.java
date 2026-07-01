package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;

@Service
public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Exercise 6: Annotation-Based Configuration");
        System.out.println("@Autowired dependency injection successful");
    }
    public void manage() {
        System.out.println("Using @Service and @Repository annotations");
        bookRepository.save();
    }
}
