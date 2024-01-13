package com.skilldev.easytraveltest.model;

import jakarta.persistence.*;

@Entity
public class Comment extends AbstractEntity{

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private User createdBy;

    private String text;

    public Comment() {}

    public Comment(Activity activity, User createdBy, String text) {
        this.activity = activity;
        this.createdBy = createdBy;
        this.text = text;
    }


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