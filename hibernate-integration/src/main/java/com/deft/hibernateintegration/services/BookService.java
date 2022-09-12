package com.deft.hibernateintegration.services;

import com.deft.hibernateintegration.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void test();
}
