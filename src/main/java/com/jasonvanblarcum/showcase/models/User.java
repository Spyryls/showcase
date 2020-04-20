package com.jasonvanblarcum.showcase.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Username is required")
    @Size(min = 3, max = 50, message = "Your username must be between 3 and 50 characters.")
    private String username;

    @NotNull(message = "Name is required")
    @Size(min = 3, max = 50, message = "Your name must be between 3 and 50 characters.")
    private String name;

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    public User(){
    }

    public User(Long id, String username, String name, String email, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
