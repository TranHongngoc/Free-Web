package com.book.bookbackend.service;

import com.book.bookbackend.DTO.BookDTO;
import com.book.bookbackend.model.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks () throws Exception;
    Book getBookById(Integer id) throws Exception;
    BookDTO getAuthorByBookId(Integer id) throws Exception;
    Book addBook(Book book) throws Exception;
    String addBook2(Book book) throws Exception;
}
