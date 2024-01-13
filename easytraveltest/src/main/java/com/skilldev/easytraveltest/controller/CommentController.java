package com.skilldev.easytraveltest.controller;

import com.skilldev.easytraveltest.model.Activity;
import com.skilldev.easytraveltest.model.Comment;
import com.skilldev.easytraveltest.model.User;
import com.skilldev.easytraveltest.repository.ActivityRepository;
import com.skilldev.easytraveltest.repository.CommentRepository;
import com.skilldev.easytraveltest.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    private static final String userSessionKey = "user";

    @PostMapping("")
    public String addComment(@ModelAttribute CommentDTO commentDTO, HttpSession session) {
        User createdBy = (User) session.getAttribute(userSessionKey);

        Activity activity = activityRepository.findById(commentDTO.getActivityId()).orElse(null);

        if (activity != null && createdBy != null) {
            // Create a new comment
            Comment comment = new Comment(activity, createdBy, commentDTO.getText());

            commentRepository.save(comment);
        }


//        return "redirect:/activities/" + commentDTO.getActivityId();
        return "activitytestpage";
    }
}
