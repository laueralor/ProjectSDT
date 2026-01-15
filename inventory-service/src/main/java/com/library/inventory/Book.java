package com.library.inventory;

public class Book {
    private String id;
    private String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters y Setters
    public String getId() { return id; }
    public String getTitle() { return title; }
}