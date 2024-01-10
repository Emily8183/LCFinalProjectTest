package com.skilldev.easytraveltest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserProfile extends AbstractEntity{

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    //    @NotNull
    private String firstName;

    //    @NotNull
    private String lastName;

    private String address;

    private String location;

    private String email;

    public UserProfile(String firstName, String lastName, String address, String location, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.location = location;
        this.email = email;
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
}
