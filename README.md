# GraphQL POC with Spring Boot

This repository contains a GraphQL Proof of Concept (POC) project using Spring Boot, showcasing the implementation of a GraphQL API with Spring Data JPA for database operations.

## Table of Contents

- [GraphQL Schema](#graphql-schema)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Run the Application](#run-the-application)
- [GraphQL Queries and Mutations](#graphql-queries-and-mutations)
- [Database Configuration](#database-configuration)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## GraphQL Schema

```graphql
type Query {
    articles: [Article]
    authors: [Author]
    authorById(id: ID!): Author
}

type Mutation {
    createArticle(title: String!, content: String, authorId: ID!): Article
    addArticle(article: ArticleInput!): Article
    updateArticle(id: ID!, article: ArticleInput!): Article
    deleteArticle(id: ID!): Article
}

input ArticleInput {
    title: String!
    content: String
    authorId: ID!
}

type Author {
    id: ID!
    firstName: String!
    lastName: String
    articles: [Article]
}

type Article {
    id: ID!
    title: String!
    content: String!
    comments: [Comment]
}

type Comment {
    id: ID!
    message: String!
}


