package com.deft.controller;

import com.deft.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Spring Booot", 13, "Deft"));
        books.add(new Book("Java Core", 16, "Deft"));

        return books;
    }
}
