package com.book.bookbackend.repo;

import com.book.bookbackend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer>, AuthorRepoCustom {
}
