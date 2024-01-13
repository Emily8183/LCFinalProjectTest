package com.skilldev.easytraveltest.controller;

import com.skilldev.easytraveltest.model.Group;
import com.skilldev.easytraveltest.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.skilldev.easytraveltest.model.Activity;
import java.util.List;
import java.util.Optional;

@RestController
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @PostMapping("/activity")
    Activity newActivity(@RequestBody Activity newActivity) {
        return activityRepository.save(newActivity);
    }

    @GetMapping("/activities")
    List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @GetMapping("/activity/{id}")
    Optional<Activity> getActivityById(@PathVariable Long id) {
        return activityRepository.findById(id);
    }

    @GetMapping("/activities/group/{id}")
    List<Activity> getAllGroups(@PathVariable Long id) {return activityRepository.findByGroupId(id);
    }


    @PutMapping("/activity/{id}")
    Optional<Activity> updateActivity(@RequestBody Activity newActivity, @PathVariable Long id){
        return activityRepository.findById(id)
                .map(activity -> {
                    activity.setEvent_name(newActivity.getEvent_name());
                    activity.setEvent_description(newActivity.getEvent_description());
                    activity.setLocation(newActivity.getLocation());
                    activity.setCost(newActivity.getCost());
                    activity.setStart_date(newActivity.getStart_date());
                    activity.setEnd_date(newActivity.getEnd_date());
                    activity.setGroup(newActivity.getGroup());
                    return activityRepository.save(activity);
                });
    }

    @DeleteMapping("/activity/{id}")
    String deleteActivity(@PathVariable Long id) {

        activityRepository.deleteById(id);
        return "User with id " + id + " has been deleted successfully.";
    }
}