package com.book.bookbackend.repo;

import com.book.bookbackend.model.Book;

import java.util.List;

public interface BookRepoCustom {
    List<Object[]> getAllBooks() throws Exception;
    Object[] getBookById(Integer id) throws Exception;
    List<Object[]> getAuthorByBookId(Integer id) throws Exception;
    List<String> getBookNames() throws Exception;
    boolean checkName(String name) throws Exception;
}
