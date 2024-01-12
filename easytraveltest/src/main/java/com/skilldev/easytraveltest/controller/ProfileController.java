package com.skilldev.easytraveltest.controller;

import com.skilldev.easytraveltest.model.User;
import com.skilldev.easytraveltest.model.UserProfile;
import com.skilldev.easytraveltest.model.dto.UserProfileDTO;
import com.skilldev.easytraveltest.repository.ProfileRepository;
import com.skilldev.easytraveltest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    private static final String userSessionKey = "user";

    @GetMapping("")
    public String displayProfileForm(Model model, HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);

        Optional<User> userOpt = userRepository.findById(userId);
        UserProfile userProfile = profileRepository.findByUserId(userId);

        UserProfileDTO userProfileDTO = new UserProfileDTO();

        if (userProfile != null) {
            userProfileDTO.setFirstName(userProfile.getFirstName());
            userProfileDTO.setLastName(userProfile.getLastName());
            userProfileDTO.setAddress(userProfile.getAddress());
            userProfileDTO.setCity(userProfile.getCity());
            userProfileDTO.setEmail(userProfile.getEmail());
        }

        model.addAttribute("username", userOpt.get().getUsername());
        model.addAttribute("userProfileDTO", userProfileDTO);

        return "profile/form";
    }

    @PostMapping("")
    // TODO: add @Valid here
    public String processProfileForm(@ModelAttribute UserProfileDTO userProfileDTO, HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);

        UserProfile userProfile = profileRepository.findByUserId(userId);

            if (userProfile == null) {
                userProfile = new UserProfile();
                userProfile.setUserId(userId);
            }

            userProfile.setFirstName(userProfileDTO.getFirstName());
            userProfile.setLastName(userProfileDTO.getLastName());
            userProfile.setAddress(userProfileDTO.getAddress());
            userProfile.setCity(userProfileDTO.getCity());
            userProfile.setEmail(userProfileDTO.getEmail());

        profileRepository.save(userProfile);

        return "redirect:/profile";
    }

}


