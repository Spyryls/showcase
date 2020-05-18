package com.jasonvanblarcum.showcase.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Username is required")
    @Size(min = 3, max = 50, message = "Your username must be between 3 and 50 characters.")
    private String username;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Size(max = 500, message = "Your bio must be under 500 characters.")
    private String bio;

    @NotNull(message = "Email is required")
    private String contactEmail;

    @NotNull(message = "Password is required")
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToMany
    private final List<Artwork> artworks = new ArrayList<>();

    public User(){}

    public User(String username, String firstName, String lastName, String bio, String contactEmail, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.contactEmail = contactEmail;
        this.pwHash = encoder.encode(password);

    }

/*    //Serves to allow us to test PostServiceStubImpl ****MAKE SURE TO TAKE OUT****
    public User(long l, String merry, Object o) {
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bio='" + bio + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", pwHash='" + pwHash + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() { return firstName;  }
    public void setFirstName(String firstName) { this.firstName = firstName;  }

    public String getLastName() { return lastName;   }
    public void setLastName(String lastName) { this.lastName = lastName;  }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public boolean isMatchingPassword(String password) {return encoder.matches(password, pwHash);}

    public void setNewPassword (String password) {this.pwHash = encoder.encode(password); }
}
