package com.skilldev.easytraveltest.model.dto;

public class LoginFormDTO {

    @NotNull(message = "Username is required")
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Username must be 3-20 characters Long.")
    private String username;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 30, message = "Password must be 6-30 characters long.")
    private String password;

    @NotNull(message = "First Name is required")
    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotNull(message = "Last Name is required")
    @NotBlank(message = "Last Name is required")
    private String lastName;




}
