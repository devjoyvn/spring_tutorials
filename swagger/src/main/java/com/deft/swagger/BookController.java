package com.deft.swagger;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("/")
    public List<Book> getAllBook() {
        return Arrays.asList(new Book("1", "Book A", "Deft", 10000));
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return new Book(id, "Book A", "Deft", 10000);
    }

    @PostMapping("/")
    public void create(@RequestBody Book book) {
        System.out.println(book.getId());
    }

    @PutMapping("/")
    public void update(@RequestBody Book book) {
        System.out.println(book.getId());
    }
}
