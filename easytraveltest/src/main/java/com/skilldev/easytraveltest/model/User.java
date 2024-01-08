package com.skilldev.easytraveltest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class User extends AbstractEntity{

    public User() {}

//    @NotNull
//    @Column(unique = true)
//    private String username;
//
//    @NotNull
//    @Column(length = 64)
//    private String password;
//
//    @NotNull
//    @Column(name = "first_name", length = 20)
//    private String firstName;
//
//    @NotNull
//    @Column(name = "last_name", length = 20)
//    private String lastName;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}
