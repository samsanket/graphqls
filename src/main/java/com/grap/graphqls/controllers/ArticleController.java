package com.grap.graphqls.controllers;


import com.grap.graphqls.models.Article;
import com.grap.graphqls.models.ArticleInput;
import com.grap.graphqls.models.Author;
import com.grap.graphqls.repository.ArticleRepository;
import com.grap.graphqls.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private  ArticleRepository articleRepository;

    @QueryMapping
    public Iterable<Article> articles() {
        return articleRepository.findAll();
    }

    @MutationMapping
    public Article createArticle(@Argument String title, @Argument String content, @Argument Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("author not found"));

        Article article = new Article();

                article.setTitle(title);
                article.setContent(content);
                article.setAuthor(author);


        return articleRepository.save(article);
    }

    @MutationMapping
    public Article addArticle(@Argument(name = "article") ArticleInput articleInput) {
        Author author = authorRepository.findById(articleInput.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("author not found"));

        Article article = new Article();

               article.setTitle(articleInput.getTitle());
                article.setContent(articleInput.getContent());
                article.setAuthor(author);


        return articleRepository.save(article);
    }

    @MutationMapping
    public Article updateArticle(@Argument Long id, @Argument(name = "article") ArticleInput articleInput) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("article not found"));

        article.setTitle(articleInput.getTitle());
        article.setContent(articleInput.getContent());
        return articleRepository.save(article);
    }

    @MutationMapping
    public void deleteArticle(@Argument Long id) {
        articleRepository.deleteById(id);
    }

}