package com.grap.graphqls.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
public class Comment {

    @Id
    @GeneratedValue
    Long id;

    String message;

    @ManyToOne(fetch = FetchType.LAZY)
    Article article;


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", article=" + article +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}