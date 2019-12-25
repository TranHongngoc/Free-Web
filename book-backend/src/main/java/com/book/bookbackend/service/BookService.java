package com.book.bookbackend.service;

import com.book.bookbackend.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks () throws Exception;
    Book createBook(Book book) throws Exception;
}
