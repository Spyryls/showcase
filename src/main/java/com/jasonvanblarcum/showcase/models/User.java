package com.jasonvanblarcum.showcase.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="users")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Username is required")
    @Size(min = 3, max = 50, message = "Your username must be between 3 and 50 characters.")
    private String username;

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Password is required")
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){
    }

    public String User(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pwHash = encoder.encode(password);

        return username;
    }


    public Integer getId() {
        return id;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMatchingPassword(String password) {return encoder.matches(password, pwHash);}

    public void setNewPassword (String password) {this.pwHash = encoder.encode(password); }
}
