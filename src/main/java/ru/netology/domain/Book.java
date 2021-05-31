package ru.netology.domain;

public class Book extends Product {
    private String Author;

    public Book(String Author) {
        this.Author = Author;
    }

    public Book(int id, int price, String name, String author) {
        super(id, price, name);
        this.Author = author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }
}
