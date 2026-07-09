# Interview Notes

This document is intended to become a professional interview-preparation artifact for the Glam & Glow project.

## Spring Boot Concepts

TODO:
- Prepare a clear explanation of the Spring Boot application lifecycle
- Explain dependency injection and the role of Spring beans
- Describe how the project is structured for maintainability

## Security

TODO:
- Explain the role of Spring Security in protecting the API
- Describe how JWT and stateless authentication fit into the design

## JWT

TODO:
- Explain token generation, validation, and expiration strategy
- Describe how the current JWT flow works in this repository

## JPA

- Explain entity mapping, repository abstraction, and persistence lifecycle
- Describe schema management strategy and future database evolution
- Discuss how the Category entity uses a repository and mapper to keep persistence concerns separate
- Explain how the Category service applies domain rules, validation, and exception handling before persistence

## Database Design

TODO:
- Explain the current user-centered schema
- Describe the future relational design for catalog, cart, order, and payment modules

## REST APIs

TODO:
- Explain how controllers, services, DTOs, and repositories collaborate
- Provide examples of clean RESTful endpoint design

## Architecture Decisions

TODO:
- Document why the project uses layered architecture
- Record why DTOs are preferred for external contracts
- Note the decision to keep controllers thin and logic in services

## Tradeoffs

TODO:
- Record tradeoffs considered for authentication strategy
- Note tradeoffs around using JPA versus a more complex data design
- Capture future tradeoffs for caching, search, and payment integration

## Behavioral Explanations

Each future feature should eventually include:

- Why we implemented it
- Alternatives considered
- Interview questions
- Interview answers

### Example Template

#### Feature: User Registration
- Why: To allow new users to create accounts securely
- Alternatives: Basic session-based auth, external identity provider
- Interview Question: How do you secure user registration?
- Interview Answer: Use hashed passwords, validation, and structured error handling
