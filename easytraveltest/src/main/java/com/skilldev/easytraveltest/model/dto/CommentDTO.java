package com.skilldev.easytraveltest.model.dto;

import com.skilldev.easytraveltest.model.Activity;
import com.skilldev.easytraveltest.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDTO {

    private Activity activity;

    private User createdBy;

    private String text;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



}
