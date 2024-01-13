package com.skilldev.easytraveltest.repository;

import com.skilldev.easytraveltest.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    List<Activity> findByGroupId(Long groupId);
}