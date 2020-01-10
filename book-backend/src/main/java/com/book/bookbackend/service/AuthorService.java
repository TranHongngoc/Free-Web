package com.book.bookbackend.service;

import com.book.bookbackend.DTO.AuthorDTO;
import com.book.bookbackend.model.Author;

import java.util.List;

public interface AuthorService {

    String addAuthor(Author author) throws Exception;
    boolean checkNameAuthor(String name) throws Exception;

    String updateAauthor(Author author) throws Exception;
    boolean checkNameUpdateAuthor(String name) throws Exception;

    void deleteAuthor(AuthorDTO ids) throws Exception;
}
