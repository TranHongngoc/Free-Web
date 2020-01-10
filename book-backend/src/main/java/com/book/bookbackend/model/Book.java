package com.book.bookbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {
    private Integer id;
    private String name;
    private Integer authorId;
    private Integer typeId;
    private Integer year;
    private Integer status;

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
    public Integer getAuthor() {
        return authorId;
    }

    public void setAuthor(Integer authorId) {
        this.authorId = authorId;
    }
    @Column(name = "type_id")
    public Integer getType() {
        return typeId;
    }

    public void setType(Integer typeId) {
        this.typeId = typeId;
    }

    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
