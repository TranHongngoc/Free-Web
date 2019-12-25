package com.book.bookbackend.repo;

import com.book.bookbackend.model.Book;

import java.util.List;

public interface BookRepo {
    List<Object[]> getAllBooks() throws Exception;

    Object[] getBookById(Integer id) throws Exception;
}
