package com.book.bookbackend.repo.impl;

import com.book.bookbackend.model.Book;
import com.book.bookbackend.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookRepoImpl implements BookRepo {

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

    @Override
    public Object[] getBookById(Integer id) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select b.id as id, b.name as name, aut.name as author, btype.name as type ");
         stringBuilder.append("from books b, author aut, book_type btype ");
         stringBuilder.append("where b.author_id=aut.id and b.type_id=btype.id and b.id=:id");
         Query query = entityManager.createNativeQuery(stringBuilder.toString());
         query.setParameter("id", id);
         Object[] book = (Object[]) query.getSingleResult();
         if (book!=null){
             return book;
         } else{
             return null;
         }
    }
}
