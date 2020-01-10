package com.book.bookbackend.service.impl;

import com.book.bookbackend.DTO.AuthorDTO;
import com.book.bookbackend.model.Author;
import com.book.bookbackend.repo.AuthorRepo;
import com.book.bookbackend.repo.AuthorRepoCustom;
import com.book.bookbackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    AuthorRepo authorRepoCustom;

    @Transactional
    @Override
    public String addAuthor(Author author) throws Exception {
        if (!checkNameAuthor(author.getName())) {
            entityManager.persist(author);
            return "OK";
        }
        return "DUPLICATE_NAME";
    }

    @Override
    public boolean checkNameAuthor(String name) throws Exception {
        boolean check = false;
        List<String> authorNames = authorRepoCustom.getAllNameAuthor();
        for(String authorName: authorNames){
            if (authorName.equalsIgnoreCase(name)){
                check = true;
                break;
            }
        }
        return check;
    }

    @Transactional
    @Override
    public String updateAauthor(Author author) throws Exception {
        if (checkNameUpdateAuthor(author.getName())) {
            entityManager.merge(author);
            return "OK";
        }
        return "DUPLICATE_NAME";
    }

    @Override
    public boolean checkNameUpdateAuthor(String name) throws Exception {
        boolean check = false;
        List<String> authorNames = authorRepoCustom.getAllNameUpdateAuthor(name);
        for(String authorName: authorNames){
            if (authorName.equalsIgnoreCase(name)){
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public void deleteAuthor(AuthorDTO ids) throws Exception {
        for (Integer id: ids.getIds()){
            Author author = authorRepoCustom.getOne(id);
//        entityManager.remove(author);
            authorRepoCustom.delete(author);
        }
    }
}
