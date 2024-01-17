package com.skilldev.easytraveltest.controller;

import com.skilldev.easytraveltest.model.*;
import com.skilldev.easytraveltest.repository.ActivityRepository;
import com.skilldev.easytraveltest.repository.ActivityTypeRepository;
import com.skilldev.easytraveltest.repository.OperatorRepository;
import com.skilldev.easytraveltest.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    private UserRepository userRepository;

//    private static final String userSessionKey = "user";

    @GetMapping("")
    public String displayActivities(@RequestParam(required = false) Integer operatorId, @RequestParam(required = false) Integer activityTypeId, Model model) {
        if (operatorId != null) {
            Optional<Operator> operatorOptional = operatorRepository.findById(operatorId);
            if (operatorOptional.isPresent()) {
                Operator operator = operatorOptional.get();
                model.addAttribute("activities", operator.getActivities());
            }
        } else if (activityTypeId != null) {
            Optional<ActivityType> activityTypeOptional = activityTypeRepository.findById(activityTypeId);
            if (activityTypeOptional.isPresent()) {
                ActivityType activityType = activityTypeOptional.get();
                model.addAttribute("activities", activityType.getActivities());
            }
        } else {
            model.addAttribute("activities", activityRepository.findAll());
        }
        return "activities/index";

    }

    @GetMapping("/add")
    public String displayAddActivityForm(Model model, HttpSession session) {
        List<Operator> operator = (List<Operator>) operatorRepository.findAll();
        List<ActivityType> activityType = (List<ActivityType>) activityTypeRepository.findAll();
        model.addAttribute("activity", new Activity());
        model.addAttribute("activityType", activityType);

        return "activities/add";
    }

    @PostMapping("/add")
    public String processAddActivity(@ModelAttribute Activity newActivity, @RequestParam String activityType) {
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//        Optional<User> userOpt = userRepository.findById(userId);
//
//        if( userOpt.isPresent()) {
//            newActivity.setUser(userOpt.get());
//            activityRepository.save(newActivity);
//        }

        if(activityType != null) {
            List<ActivityType> selectedActivityType = (List<ActivityType>) activityTypeRepository.findAll(activityType);
            newActivity.setActivityType(selectedActivityType);

        }
        activityRepository.save(newActivity);
        return "redirect:/activities";
    }
}



//    @PostMapping("")
//    public String Activity(@RequestBody Activity newActivity) {
////        return activityRepository.save(newActivity);
////
//
//
//
//    @GetMapping("/activity/{id}")
//    Optional<Activity> getActivityById(@PathVariable Long id) {
//        return activityRepository.findById(id);
//    }
//
//    @GetMapping("/activities/group/{id}")
//    List<Activity> getAllGroups(@PathVariable Long id) {return activityRepository.findByGroupId(id);
//    }
//
//
//    @PutMapping("/activity/{id}")
//    Optional<Activity> updateActivity(@RequestBody Activity newActivity, @PathVariable Long id){
//        return activityRepository.findById(id)
//                .map(activity -> {
//                    activity.setEvent_name(newActivity.getEvent_name());
//                    activity.setEvent_description(newActivity.getEvent_description());
//                    activity.setLocation(newActivity.getLocation());
//                    activity.setCost(newActivity.getCost());
//                    activity.setStart_date(newActivity.getStart_date());
//                    activity.setEnd_date(newActivity.getEnd_date());
//                    activity.setGroup(newActivity.getGroup());
//                    return activityRepository.save(activity);
//                });
//    }
//
//    @DeleteMapping("/activity/{id}")
//    String deleteActivity(@PathVariable Long id) {
//
//        activityRepository.deleteById(id);
//        return "User with id " + id + " has been deleted successfully.";
//    }
