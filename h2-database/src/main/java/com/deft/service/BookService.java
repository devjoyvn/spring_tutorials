package com.deft.service;

import com.deft.dto.BookDTO;

import java.util.List;

public interface BookService {

    void create(BookDTO dto);

    List<BookDTO> findAll();
}
