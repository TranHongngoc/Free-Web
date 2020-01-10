package com.book.bookbackend.repo;

import com.book.bookbackend.model.Author;

import java.util.List;

public interface AuthorRepoCustom {

    List<String> getAllNameAuthor() throws Exception;
    List<String> getAllNameUpdateAuthor(String name) throws Exception;
}
