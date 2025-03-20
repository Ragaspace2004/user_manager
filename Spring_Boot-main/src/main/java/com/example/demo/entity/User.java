package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data")// Table name in PostgreSQL
public class User {
    @Id
    private Integer id;
    private String name;
    private String email;

    public User() {}

    public User(Integer id,String name, String email) {
        this.id =id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
