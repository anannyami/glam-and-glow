# Project Roadmap

This document tracks the engineering progress of the Glam & Glow backend as a living project artifact.

## Current Project Status

The repository currently contains a Spring Boot 3 backend with:

- Java 17 and Maven build configuration
- Spring Security and JWT-based authentication
- PostgreSQL and JPA configuration
- Swagger/OpenAPI integration
- Basic user registration and login flow
- DTO-based request/response handling
- Basic exception handling and integration tests

## Completed Features

### Phase 1 - Authentication
- [x] Project scaffolding
- [x] Maven configuration
- [x] PostgreSQL configuration
- [x] JPA configuration
- [x] Swagger integration
- [x] JWT utility and filter
- [x] Spring Security configuration
- [x] Password encoding setup
- [x] Login API
- [x] User entity and role entity
- [x] User repository and service
- [x] Global exception handling
- [x] Basic authentication integration tests

### Category Persistence Milestone
- [x] Category entity
- [x] Category repository
- [x] Category request DTO
- [x] Category response DTO
- [x] Category mapper
- [x] Persistence-layer design review

### Category Business Layer Milestone
- [x] Category service
- [x] Category-specific exceptions
- [x] Business validation
- [x] Duplicate slug handling
- [x] Duplicate name handling
- [x] Create/update/delete/lookups
- [x] Pagination-ready design
- [x] Logging

## Pending Features

### Phase 2 - Users
- [ ] User profile management
- [ ] Address management
- [ ] Profile update flow
- [ ] User-specific access control

### Phase 3 - Catalog
- [ ] Category management
- [ ] Product CRUD
- [ ] Product images
- [ ] Inventory handling
- [ ] Search and filtering

### Phase 4 - Commerce
- [ ] Wishlist
- [ ] Shopping cart
- [ ] Coupons
- [ ] Orders
- [ ] Payments

### Phase 5 - Experience and Growth
- [ ] Reviews and ratings
- [ ] Email notifications
- [ ] Community forum
- [ ] AI cart analyzer

## Development Phases

| Phase | Focus | Status |
| --- | --- | --- |
| Phase 1 | Authentication foundation | In progress / baseline established |
| Phase 2 | User management | Planned |
| Phase 3 | Categories and products | Planned |
| Phase 4 | Commerce lifecycle | Planned |
| Phase 5 | Experience and AI features | Planned |

## Progress Checklist

### Engineering Foundation
- [x] Layered backend structure
- [x] DTO-based API contract
- [x] Validation support
- [x] Testing baseline
- [ ] Mapper layer
- [ ] Environment variable externalization
- [ ] Structured logging
- [ ] Docker and CI/CD foundation

### Documentation
- [x] Repository guidance file
- [x] Project roadmap
- [ ] Architecture documentation
- [ ] Database design document
- [ ] API standards document
- [ ] DevOps checklist
- [ ] Review checklist

## Milestones

### Milestone 1 - Authentication Baseline
Completed with a working registration/login flow and JWT authentication.

### Milestone 2 - User Domain Expansion
Planned for profile and address management.

### Milestone 3 - Product Catalog
Planned for categories and product management.

### Milestone 4 - Commerce Workflow
Planned for cart, orders, and payments.

## Future Improvements

- Introduce a dedicated mapper layer for DTO/entity transformation
- Externalize secrets and configuration values
- Add pagination, sorting, and filtering from the beginning for list endpoints
- Improve monitoring and observability
- Add Docker and GitHub Actions workflows
- Expand test coverage to service and controller layers

## Notes

This roadmap should be updated whenever a major feature is completed, delayed, or redesigned.
