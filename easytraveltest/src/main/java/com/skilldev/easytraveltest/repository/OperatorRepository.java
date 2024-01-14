package com.skilldev.easytraveltest.repository;

import com.skilldev.easytraveltest.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Integer> {

}