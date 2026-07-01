package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Exercise 7: Constructor Injection");
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Exercise 7: Setter Injection");
    }
    public void manage() {
        System.out.println("Both injection types demonstrated");
        bookRepository.save();
    }
}
