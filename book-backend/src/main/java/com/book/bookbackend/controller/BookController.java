package com.book.bookbackend.controller;

import com.book.bookbackend.model.Book;
import com.book.bookbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        try {
            return bookService.createBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
