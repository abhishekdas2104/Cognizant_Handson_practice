package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Exercise 5: IoC Container Configuration");
    }
    public void manage() {
        System.out.println("Spring IoC managing bean dependencies");
        bookRepository.save();
    }
}
