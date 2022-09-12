package com.deft.hibernateintegration.services.impl;

import com.deft.hibernateintegration.entities.Book;
import com.deft.hibernateintegration.repositories.BookRepository;
import com.deft.hibernateintegration.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void test() {
        Book book = new Book();
        book.setName("AAA");
        bookRepository.save(book);
        throw new RuntimeException("haha");
    }
}
