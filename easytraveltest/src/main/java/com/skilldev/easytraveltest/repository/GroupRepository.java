package com.skilldev.easytraveltest.repository;

import com.skilldev.easytraveltest.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

}