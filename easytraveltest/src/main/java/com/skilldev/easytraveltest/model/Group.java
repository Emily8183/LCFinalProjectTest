package com.skilldev.easytraveltest.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Group extends AbstractEntity{

    private String group_name;
    private String organizer;
    private String organizer_email;

    @OneToMany(mappedBy = "group")
    private final List<Activity> activities = new ArrayList<>();

    public Group() {}

    public Group(String group_name, String organizer, String organizer_email) {
        this.group_name = group_name;
        this.organizer = organizer;
        this.organizer_email = organizer_email;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getOrganizer_email() {
        return organizer_email;
    }

    public void setOrganizer_email(String organizer_email) {
        this.organizer_email = organizer_email;
    }
}