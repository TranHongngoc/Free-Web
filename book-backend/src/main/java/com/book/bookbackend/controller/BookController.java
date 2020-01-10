package com.book.bookbackend.controller;

import com.book.bookbackend.DTO.BookDTO;
import com.book.bookbackend.helper.ApiResponse;
import com.book.bookbackend.model.Book;
import com.book.bookbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public ApiResponse getBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            if (books != null) {
                return ApiResponse.build(HttpServletResponse.SC_OK, true, "", books);
            } else {
                return ApiResponse.build(HttpServletResponse.SC_OK, true, "", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, "", null);
        }
    }

    @PostMapping("/getBookById")
    public ApiResponse getBookById(@RequestBody BookDTO bookDTO) {
        try {
            Book book = bookService.getBookById(bookDTO.getId());
            if (book!=null){
                return ApiResponse.build(HttpServletResponse.SC_OK, true, "", book);
            } else {
                return ApiResponse.build(HttpServletResponse.SC_OK, true, "", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, "", null);
        }
    }

    @PostMapping("/getAuthorByBookId")
    public ApiResponse getAuthorByBookId(@RequestBody BookDTO bookDTO) {
        try {
            BookDTO bookDTO1 = bookService.getAuthorByBookId(bookDTO.getId());
            return ApiResponse.build(HttpServletResponse.SC_OK, true, "", bookDTO1);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, "", null);
        }
    }

    @PostMapping("/addBook")
    public ApiResponse addBook(@RequestBody Book book) {
        try {
            String mess = bookService.addBook2(book);
            return ApiResponse.build(HttpServletResponse.SC_OK, true, "", mess);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }
}
