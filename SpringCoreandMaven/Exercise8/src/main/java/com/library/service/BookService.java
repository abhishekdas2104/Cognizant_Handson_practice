package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void manage() {
        System.out.println("Exercise 8: AOP with @Before and @After");
        bookRepository.save();
    }
}
