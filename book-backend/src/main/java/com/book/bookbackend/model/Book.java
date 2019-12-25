package com.book.bookbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "author_id")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "type_id")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
