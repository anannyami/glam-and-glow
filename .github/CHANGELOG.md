# Changelog

All notable changes to Glam & Glow will be documented in this file.

The format is based on Keep a Changelog, and this project adheres to semantic versioning-style release notes.

## [v0.1.0] - 2026-07-08

### Added
- Initial Spring Boot backend structure
- Maven and Java 17 build configuration
- PostgreSQL and JPA configuration
- Spring Security and JWT authentication setup
- User registration and login flow
- DTO-based request and response handling
- Basic exception handling
- Initial integration test coverage for authentication
- Category entity and persistence-layer DTOs
- Category repository and mapper
- Category service with validation, duplicate handling, lookups, and pagination-ready design

### Changed
- Refined the authentication flow to use dedicated DTOs and structured API responses

### Fixed
- Confirmed the authentication flow builds and passes tests

### Notes
- This release establishes the authentication foundation and project structure for future e-commerce modules.

## [Unreleased]

### Planned
- User profile and address management
- Category and product modules
- Cart and checkout flow
- Payments and order lifecycle
- Docker and CI/CD setup
- Expanded documentation and engineering standards
