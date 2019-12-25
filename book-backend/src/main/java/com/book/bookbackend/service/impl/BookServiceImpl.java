package com.book.bookbackend.service.impl;

import com.book.bookbackend.model.Book;
import com.book.bookbackend.repo.BookRepo;
import com.book.bookbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() throws Exception {
        List<Object[]> bookObjects = bookRepo.getAllBooks();
        List<Book> books = new ArrayList<>();
        for (Object[] book: bookObjects){
            Book book1 = new Book();
            book1.setId((Integer) book[0]);
            book1.setName((String) book[1]);
            book1.setAuthor((String) book[2]);
            book1.setType((String) book[3]);
            books.add(book1);
        }
        return books;
    }
}
