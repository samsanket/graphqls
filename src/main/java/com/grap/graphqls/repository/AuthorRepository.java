package com.grap.graphqls.repository;

import com.grap.graphqls.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}