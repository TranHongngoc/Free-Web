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
        stringBuilder.append("select b.id as id, b.name as bookname, a.name as author, t.name as type, b.year as year, b.img_name as image, b.book_code ");
        stringBuilder.append("from books b, author a, book_type t ");
        stringBuilder.append("where b.type_id=t.id and b.author_id=a.id");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
//        query.setFirstResult(1);
//        query.setMaxResults(3);
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

    @Override
    public List<Object[]> getAuthorByBookId(Integer id) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select b.name as name, aut.name as author_name " );
         stringBuilder.append("from books b, author aut, book_author baut " );
         stringBuilder.append("where b.id= :bookId " );
         stringBuilder.append("and b.id=baut.book_id " );
         stringBuilder.append("and aut.id=baut.author_id ");
         Query query = entityManager.createNativeQuery(stringBuilder.toString());
         query.setParameter("bookId", id);
        return query.getResultList();
    }

    @Override
    public List<String> getBookNames() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select name from books");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        return query.getResultList();
    }

    @Override
    public boolean checkName(String name) throws Exception {
        boolean check = false;
        List<String> bookNames = getBookNames();
        for(String bookName: bookNames) {
            if (bookName.equalsIgnoreCase(name)) {
                check = true;
                break;
            }
        }
        return check;
    }
}
