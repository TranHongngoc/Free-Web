package com.book.bookbackend.controller;

import com.book.bookbackend.DTO.AuthorDTO;
import com.book.bookbackend.helper.ApiResponse;
import com.book.bookbackend.model.Author;
import com.book.bookbackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public ApiResponse addAuthor(@RequestBody Author author) {
        try {
            String mess = authorService.addAuthor(author);
            return ApiResponse.build(HttpServletResponse.SC_OK, true, "", mess);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @PostMapping("/updateAuthor")
    public ApiResponse updateAuthor(@RequestBody Author author) {
        try {
            String mess = authorService.updateAauthor(author);
            return ApiResponse.build(HttpServletResponse.SC_OK, true, "", mess);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @PostMapping("/delete")
    public ApiResponse deleteAuthor(@RequestBody AuthorDTO ids) {
        try {
            authorService.deleteAuthor(ids);
            return ApiResponse.build(HttpServletResponse.SC_OK, true, "", null);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.build(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }
}
