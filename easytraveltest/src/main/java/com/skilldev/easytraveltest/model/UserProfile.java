package com.skilldev.easytraveltest.model;

import jakarta.persistence.Entity;

@Entity
public class UserProfile extends AbstractEntity{

    private int userId;

      //    @NotNull
    private String firstName;

    //    @NotNull
    private String lastName;

    private String address;

    private String city;

    private String email;

    public UserProfile() {}

    public UserProfile(int userId, String firstName, String lastName, String address, String city, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
