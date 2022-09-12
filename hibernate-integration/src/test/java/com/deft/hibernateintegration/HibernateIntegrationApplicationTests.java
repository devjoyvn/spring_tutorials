package com.deft.hibernateintegration;

import com.deft.hibernateintegration.entities.Book;
import com.deft.hibernateintegration.repositories.BookRepository;
import com.deft.hibernateintegration.services.BookService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateIntegrationApplicationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @BeforeAll
    void setup() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3));
    }

    @Test
    void loadTest() {
        List<Book> books = bookService.findAll();

        assertEquals(3, books.size());
    }
}
