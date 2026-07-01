package com.library.repository;

public class BookRepository {
    public void save() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Saving book to database");
    }
}
