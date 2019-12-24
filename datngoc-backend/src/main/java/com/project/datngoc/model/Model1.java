package com.project.datngoc.model;

import javax.persistence.*;

@Entity
@Table(name = "table_test")
public class Model1 {
    private Integer id;
    private String name;

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
}
