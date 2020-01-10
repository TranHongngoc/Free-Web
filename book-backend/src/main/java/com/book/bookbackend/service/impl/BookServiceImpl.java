package com.book.bookbackend.service.impl;

import com.book.bookbackend.DTO.BookDTO;
import com.book.bookbackend.model.Book;
import com.book.bookbackend.repo.BookRepo;
import com.book.bookbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<BookDTO> getAllBooks() throws Exception {
        List<Object[]> bookObjects = bookRepo.getAllBooks();
        List<BookDTO> books = new ArrayList<>();
        for (Object[] book: bookObjects){
            BookDTO book1 = new BookDTO();
            book1.setId((Integer) book[0]);
            book1.setBookName((String) book[1]);
            book1.setAuthor((String) book[2]);
            book1.setType((String) book[3]);
            books.add(book1);
        }
        return books;
    }

    @Override
    public Book getBookById(Integer id) throws Exception {
        Object[] object = bookRepo.getBookById(id);
        Book book = new Book();
        book.setId((Integer) object[0]);
        book.setName((String) object[1]);
        book.setAuthor((Integer) object[2]);
        book.setType((Integer) object[3]);
//        book.setId((Integer) object[0]);
        return book;
    }

    @Override
    public BookDTO getAuthorByBookId(Integer id) throws Exception {
        List<Object[]> objects = bookRepo.getAuthorByBookId(id);
        List<String> authorList = new ArrayList<>();
        String bookName =null;
        BookDTO bookDTO = new BookDTO();
        for(Object[] object: objects){
            bookName = (String) object[0];
            String authorName = (String) object[1];
            authorList.add(authorName);
        }

//        bookDTO.setBookName((String) objects.get(0)[0]);
        bookDTO.setId(id);
        bookDTO.setBookName(bookName);
        bookDTO.setAuthorNames(authorList);
        return bookDTO;
    }

    @Transactional
    @Override
    public Book addBook(Book book) throws Exception {
        return bookRepo.save(book);
    }

    @Transactional
    @Override
    public String addBook2(Book book) throws Exception {
        if (!bookRepo.checkName(book.getName())) {
            entityManager.persist(book);
            return "OK";
        }
        return "False";
    }
}
