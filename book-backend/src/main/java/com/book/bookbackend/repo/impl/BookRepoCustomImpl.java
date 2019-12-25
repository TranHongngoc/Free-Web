package com.book.bookbackend.repo.impl;

import com.book.bookbackend.repo.BookRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BookRepoCustomImpl implements BookRepoCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Object[]> getAllBooks() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select b.id as id, b.name as bookname, a.name as author, t.name as type ");
        stringBuilder.append("from books b, author a, book_type t ");
        stringBuilder.append("where b.type_id=t.id and b.author_id=a.id");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        List<Object[]> books = query.getResultList();
        if (books != null) {
            return books;
        } else {
            return null;
        }
    }
}
