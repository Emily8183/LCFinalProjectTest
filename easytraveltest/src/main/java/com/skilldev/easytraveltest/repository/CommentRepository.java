package com.skilldev.easytraveltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.xml.stream.events.Comment;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
  Comment findByCommentId(int id);

}
