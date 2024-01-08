package com.grap.graphqls.controllers;


import com.grap.graphqls.models.Author;
import com.grap.graphqls.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    @Autowired
    private  AuthorRepository authorRepository;

    // function name needs to match what is defined in the
    // graphql schema
    @QueryMapping
    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    // @argument annotation, not traditional @PathVariable
    @QueryMapping
    public Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }


}