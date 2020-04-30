package com.jasonvanblarcum.showcase.models.dto;

import javax.validation.constraints.Email;

public class RegistrationFormDTO extends LoginFormDTO{

    private String firstName;

    private String lastName;

    @Email(message="Please, enter an email in 'you@email.com' format")
    private String contactEmail;

    private String verifyPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
