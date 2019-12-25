package com.book.bookbackend.repo;

import com.book.bookbackend.model.Book;

import java.util.List;

public interface BookRepoCustom {
    List<Object[]> getAllBooks() throws Exception;
}
