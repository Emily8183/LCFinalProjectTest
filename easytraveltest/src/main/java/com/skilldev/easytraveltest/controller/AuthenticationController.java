package com.skilldev.easytraveltest.controller;

import com.skilldev.easytraveltest.model.User;
import com.skilldev.easytraveltest.model.dto.LoginFormDTO;
import com.skilldev.easytraveltest.model.dto.RegistrationFormDTO;
import com.skilldev.easytraveltest.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;
import java.util.Optional;


@Controller
public class AuthenticationController {


    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    //define the static method setUserInSession to use when they first register or successfully log in by giving them a userId in the session. It's meant to check if we have the session and the user.
    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    public User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);

        if (userId == null) {
            return null;
        }

        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isEmpty()) {
            return null;
        }

        return userOpt.get();
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model, HttpSession session) {

        model.addAttribute(new RegistrationFormDTO());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "registration_form";
    }

    @PostMapping("/register")
    //TODO: add @Valid here
    public String processRegister(@ModelAttribute RegistrationFormDTO registrationFormDTO, Errors errors, HttpServletRequest request){

        if (errors.hasErrors()) {
            return "registration_form";
        }

        User existingUser = userRepository.findByUsername(registrationFormDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyExists", "A user with that username already exists");
            return "registration_form";
        }

        String password = registrationFormDTO.getPassword();
        String verifyPassword = registrationFormDTO.getVerifyPassword();
        if(!password.equals(verifyPassword)) {
            errors.rejectValue("password","passwords.mismatch","Passwords do not match");
            return "registration_form";
        }

        User newUser = new User(
                registrationFormDTO.getUsername(),
                registrationFormDTO.getPassword()
        );
        userRepository.save(newUser);
        setUserInSession(request.getSession(),newUser);
        return "register_success";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model, HttpSession session) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "login";
    }

    @PostMapping("/login")
    // TODO: add @Valid here
    public String processLoginForm(@ModelAttribute LoginFormDTO loginFormDTO, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "login";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        String password = loginFormDTO.getPassword();

        if (theUser == null || !theUser.isMatchingPassword(password)) {
            errors.rejectValue(
                    "password",
                    "login.invalid",
                    "Credentials invalid. Please try again with correct username/password."
            );
            return "login";
        }

        setUserInSession(request.getSession(), theUser);
        return "login_success";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }


}