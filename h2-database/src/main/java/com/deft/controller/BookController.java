package com.deft.controller;

        import com.deft.dto.BookDTO;
        import com.deft.service.BookService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void create(@RequestBody BookDTO dto) {
        bookService.create(dto);
    }

    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }
}
