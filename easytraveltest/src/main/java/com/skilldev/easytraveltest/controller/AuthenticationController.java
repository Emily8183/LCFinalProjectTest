package com.skilldev.easytraveltest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/register")
    public String showRegistrationForm(model model) {
        model.addAttribution("user", new User());

        return "registration_form";
    }

}
