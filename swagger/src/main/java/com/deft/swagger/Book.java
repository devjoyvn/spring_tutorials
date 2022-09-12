package com.deft.swagger;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Book {

    @NotNull(message = "ID can't be null")
    private String id;

    @NotNull(message = "Name can't be null")
    private String name;

    private String author;

    @Min(value = 0, message = "Min Price can't be positive")
    private Integer price;


    public Book() {
    }

    public Book(String id, String name, String author, Integer price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
