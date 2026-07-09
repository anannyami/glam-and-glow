# Code Review Checklist

Use this checklist before every merge to maintain engineering quality.

## Architecture

- [ ] The change fits the layered architecture
- [ ] New code does not bypass service boundaries unnecessarily
- [ ] The solution is consistent with project conventions

## Readability

- [ ] Code is easy to read and understand
- [ ] Methods and classes have meaningful names
- [ ] Complex logic is broken into smaller units where needed

## Naming

- [ ] Names are clear and consistent
- [ ] DTOs, services, controllers, and entities follow naming conventions

## SOLID

- [ ] The change follows the single responsibility principle
- [ ] Dependencies are injected appropriately
- [ ] The design avoids unnecessary coupling

## Clean Code

- [ ] Code is formatted consistently
- [ ] Duplication is avoided
- [ ] Comments are used only when necessary

## Performance

- [ ] The implementation avoids obvious inefficiencies
- [ ] Database access is reasonable and scalable
- [ ] Large loops or repeated queries are reviewed carefully

## Security

- [ ] Sensitive data is not logged or exposed
- [ ] Authentication and authorization are respected
- [ ] Input is validated and encoded properly

## Validation

- [ ] Incoming requests are validated
- [ ] Failure cases return appropriate status codes
- [ ] Error handling is clear and consistent

## Testing

- [ ] Relevant tests cover the change
- [ ] New features are verified through tests where appropriate
- [ ] Regression risk is considered

## Documentation

- [ ] Public APIs are documented clearly
- [ ] Important behavior is understandable to future maintainers
- [ ] Any TODOs or follow-up work are recorded

## Logging

- [ ] Important actions are logged appropriately
- [ ] Logs do not expose secrets or sensitive information

## Exception Handling

- [ ] Exceptions are handled in a consistent way
- [ ] User-facing errors are meaningful
- [ ] Unexpected failures do not leak internal details unnecessarily

## Database

- [ ] Queries are efficient and appropriate
- [ ] Relationships and constraints are reviewed
- [ ] Schema changes are documented

## Swagger

- [ ] Public endpoints are documented clearly
- [ ] Request and response models are understandable

## Final Merge Gate

- [ ] Build passes
- [ ] Tests pass
- [ ] Documentation is updated if needed
- [ ] The change is ready for another engineer to maintain
