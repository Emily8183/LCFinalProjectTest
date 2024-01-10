package com.skilldev.easytraveltest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.validation.constraints.NotNull;
import jakarta.persistence.OneToOne;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
public class User extends AbstractEntity{

//    @NotNull
    private String username;

    private String pwHash;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    //should not able to be overwritten
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    @OneToOne
    private UserProfile userProfile;

}
