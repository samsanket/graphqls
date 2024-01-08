package com.grap.graphqls.config;


import com.grap.graphqls.models.Article;
import com.grap.graphqls.models.Author;
import com.grap.graphqls.models.Comment;
import com.grap.graphqls.repository.ArticleRepository;
import com.grap.graphqls.repository.AuthorRepository;
import com.grap.graphqls.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SeedDataConfig implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private  ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {


        if (authorRepository.count() == 0) {

            Author author1 = new Author(); author1.setFirstName("Jack");author1.setLastName("Pain");
            author1 = authorRepository.save(author1);


            Article article1 = new Article();
                   article1.setTitle("article 1");
                   article1 .setContent("this is article 1");
                   article1 .setAuthor(author1);


            Article article2 = new Article();
            article2.setTitle("article 2");
            article2 .setContent("this is article 2");
            article2 .setAuthor(author1);

            articleRepository.save(article1);
            articleRepository.save(article2);

            Comment comment1 = new Comment();
                    comment1.setMessage("great article");
                    comment1.setArticle(article1);

            Comment comment2 = new Comment();
            comment2.setMessage("good article");
            comment2.setArticle(article1);

            commentRepository.save(comment1);
            commentRepository.save(comment2);

        }
    }

}