package com.book.bookbackend.repo;

import com.book.bookbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>,BookRepoCustom {

}
