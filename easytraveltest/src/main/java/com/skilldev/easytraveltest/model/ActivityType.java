package com.skilldev.easytraveltest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ActivityType extends AbstractEntity{

    private String name;

    @ManyToMany(mappedBy = "activityTypes")
    private final List<Activity> activities = new ArrayList<>();

    public ActivityType() {}

    public ActivityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
