package com.skilldev.easytraveltest.model;

import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
public class User extends AbstractEntity{

//    @NotNull
    private String username;

    private String pwHash;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private UserProfile profile;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    //    public User(String username, UserProfile profile) {
//        this.username =username;
//        this.profile = profile;
//    }

    public String getUsername() {
        return username;
    }

    //should not able to be overwritten
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
