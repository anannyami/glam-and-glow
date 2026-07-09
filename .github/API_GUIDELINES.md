# API Guidelines

This document defines the standards for API development in Glam & Glow.

## Endpoint Naming

- Use lowercase, resource-oriented names
- Prefer plural nouns for collections
- Use RESTful paths such as `/users`, `/products`, `/orders`
- Use action-specific verbs only when necessary

## REST Conventions

- Use `GET` for read operations
- Use `POST` for creation
- Use `PUT` or `PATCH` for updates
- Use `DELETE` for removal
- Keep endpoints predictable and consistent

## DTO Naming

- Use `RequestDTO` for incoming payloads
- Use `ResponseDTO` for outgoing payloads
- Use descriptive names such as `RegisterRequestDTO` and `UserResponseDTO`
- Avoid exposing entity classes directly through APIs

## Validation

- Validate all incoming request bodies
- Use Bean Validation annotations where appropriate
- Return clear validation errors with meaningful field messages

## Authentication

- Use JWT-based authentication for protected endpoints
- Prefer Bearer token authentication
- Keep authentication logic in the security layer and service layer

## Authorization

TODO:
- Define role-based access rules for admin and regular users
- Define ownership rules for user-specific resources

## Response Format

Responses should be consistent and predictable.

Recommended pattern:

```json
{
  "success": true,
  "message": "Operation completed successfully",
  "data": {},
  "timestamp": "2026-07-08T00:00:00"
}
```

## Error Format

Errors should be structured and easy to consume.

Recommended pattern:

```json
{
  "success": false,
  "message": "Validation failed",
  "timestamp": "2026-07-08T00:00:00"
}
```

## Pagination

TODO:
- Define standard query parameters for pagination
- Use page size and page number conventions

## Sorting

TODO:
- Define a standard sort parameter pattern
- Support directional sorting where appropriate

## Filtering

TODO:
- Define reusable filter conventions for catalog and admin endpoints

## Versioning Strategy

Current state:
- No explicit versioning strategy has been introduced yet

Recommended future direction:
- Consider `/api/v1/...` for long-term API stability

## HTTP Status Codes

Use statuses consistently:

- `200 OK` for successful reads and updates
- `201 Created` for successful resource creation
- `204 No Content` for successful deletion
- `400 Bad Request` for validation or malformed input
- `401 Unauthorized` for missing or invalid authentication
- `403 Forbidden` for insufficient permissions
- `404 Not Found` for missing resources
- `409 Conflict` for duplicate resources

## Swagger Documentation

- Document controllers and request/response models
- Ensure all public endpoints are understandable through Swagger UI

## Notes

This document should evolve as the API surface grows.
