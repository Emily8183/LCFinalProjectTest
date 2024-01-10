package com.skilldev.easytraveltest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
public class User extends AbstractEntity{

//    @NotNull
    private String username;

    private String pwHash;

//    @NotNull
    private String firstName;

//    @NotNull
    private String lastName;

    private String address;

    private String location;

    private String email;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(String firstName, String lastName, String address, String location, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.location = location;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //not able to be overwritten
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
