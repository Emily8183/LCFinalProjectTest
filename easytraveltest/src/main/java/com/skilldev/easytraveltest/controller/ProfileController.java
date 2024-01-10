package com.skilldev.easytraveltest.controller;

import com.skilldev.easytraveltest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping("")
    public String viewProfile () {

//        model.addAttribute("user",user);
        return "profile/view";
    }



}
