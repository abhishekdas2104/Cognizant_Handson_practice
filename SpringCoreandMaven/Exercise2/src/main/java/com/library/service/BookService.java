package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Exercise 2: Dependency Injection via Setter");
    }
    public void manage() {
        System.out.println("BookService using injected BookRepository");
        bookRepository.save();
    }
}
