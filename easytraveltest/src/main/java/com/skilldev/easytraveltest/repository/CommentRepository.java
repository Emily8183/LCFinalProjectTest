package com.skilldev.easytraveltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.xml.stream.events.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    //shouldn't need "Comment findByCommentId(int id)" since findById is built in
}
