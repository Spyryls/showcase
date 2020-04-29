package com.jasonvanblarcum.showcase.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginFormDTO {

    @NotBlank
    @Size(min = 3, max = 50, message = "Your username must be between 3 and 50 characters.")
    private String username;

    @NotBlank
    @Size(min = 6, max = 50, message = "Your password must be between 6 and 50 characters.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
