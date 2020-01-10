package com.book.bookbackend.repo.impl;

import com.book.bookbackend.model.Author;
import com.book.bookbackend.repo.AuthorRepo;
import com.book.bookbackend.repo.AuthorRepoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AuthorRepoImpl implements AuthorRepoCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<String> getAllNameAuthor() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select name from author");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        return query.getResultList();
    }

    @Override
    public List<String> getAllNameUpdateAuthor(String name) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select name from author where name<>:name");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        query.setParameter("name", name);
        return query.getResultList();
    }
}
