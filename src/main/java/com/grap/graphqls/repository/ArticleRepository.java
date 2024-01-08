package com.grap.graphqls.repository;

import com.grap.graphqls.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}