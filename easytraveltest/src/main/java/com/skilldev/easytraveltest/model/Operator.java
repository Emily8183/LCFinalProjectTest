package com.skilldev.easytraveltest.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Operator extends AbstractEntity{

    private String name;
    private String email;

    @ManyToMany (mappedBy = "operators")
    private final List<Activity> activities = new ArrayList<>();


    public Operator() {}

    public Operator(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}