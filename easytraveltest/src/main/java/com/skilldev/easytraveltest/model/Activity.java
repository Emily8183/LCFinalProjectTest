package com.skilldev.easytraveltest.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Activity extends AbstractEntity{

    private String event_name;
    private String event_description;
    private Float cost;
    private String location;
    private String start_date;
    private String end_date;

    @ManyToMany
    private List<ActivityType> activityTypeList;

    @ManyToOne
    @JoinColumn(name= "group_id", nullable = false)
    private Group group;

    public Activity(String event_name, String event_description, Float cost, String location, String start_date, String end_date, List<ActivityType> activityTypeList, Group group) {
        this.event_name = event_name;
        this.event_description = event_description;
        this.cost = cost;
        this.location = location;
        this.start_date = start_date;
        this.end_date = end_date;
        this.activityTypeList = activityTypeList;
        this.group = group;
    }

    public List<ActivityType> getActivityTypeList() {
        return activityTypeList;
    }

    public void setActivityTypeList(List<ActivityType> activityTypeList) {
        this.activityTypeList = activityTypeList;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}