package com.skilldev.easytraveltest.controller;

import com.skilldev.easytraveltest.model.Group;
import com.skilldev.easytraveltest.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @PostMapping("/group")
    Group newGroup(@RequestBody Group newGroup) {
        return groupRepository.save(newGroup);
    }

    @GetMapping("/groups")
    List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/group/{id}")
    Optional<Group> getGroupById(@PathVariable Long id) {
        return groupRepository.findById(id);
    }

    @PutMapping("/group/{id}")
    Optional<Group> updateGroup(@RequestBody Group newGroup, @PathVariable Long id){
        return groupRepository.findById(id)
                .map(group -> {
                    group.setGroup_name(newGroup.getGroup_name());
                    group.setOrganizer(newGroup.getOrganizer());
                    group.setOrganizer_email(newGroup.getOrganizer_email());
                    return groupRepository.save(group);
                });
    }

    @DeleteMapping("/group/{id}")
    String deleteGroup(@PathVariable Long id) {
        ;
        groupRepository.deleteById(id);
        return "Group with id " + id + " has been deleted successfully.";
    }
}