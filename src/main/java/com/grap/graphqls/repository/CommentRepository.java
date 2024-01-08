package com.grap.graphqls.repository;


import com.grap.graphqls.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}