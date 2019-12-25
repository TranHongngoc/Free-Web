package com.book.bookbackend.controller;

import com.book.bookbackend.DTO.BookDTO;
import com.book.bookbackend.model.Book;
import com.book.bookbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            if (books != null) {
                return books;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/getBookById")
    public Book getBookById(@RequestBody BookDTO bookDTO) {
        try {
            Book book = bookService.getBookById(bookDTO.getId());
            if (book!=null){
                return book;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
