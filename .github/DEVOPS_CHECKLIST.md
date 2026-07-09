# DevOps Checklist

This checklist captures the engineering and operational work still needed to make Glam & Glow deployment-ready.

## Environment Variables

- [ ] Externalize database credentials
- [ ] Externalize JWT secret and expiration settings
- [ ] Externalize application configuration for different environments

## Docker

- [ ] Create a Dockerfile for the backend
- [ ] Define container runtime settings
- [ ] Ensure the application can run inside a container

## Docker Compose

- [ ] Add a compose file for app and PostgreSQL
- [ ] Configure service networking and persistence
- [ ] Document local startup steps

## CI/CD

- [ ] Add GitHub Actions workflow for build and test
- [ ] Add automated checks for pull requests
- [ ] Configure deployment pipelines for staging or production

## GitHub Actions

- [ ] Run Maven tests on pull request
- [ ] Cache Maven dependencies
- [ ] Build the application artifact

## Logging

- [ ] Add structured application logging
- [ ] Configure log levels for development and production
- [ ] Ensure important business operations are logged

## Monitoring

- [ ] Add health endpoints
- [ ] Add basic observability strategy
- [ ] Plan alerting and error monitoring

## Deployment

- [ ] Prepare deployment configuration for a cloud platform
- [ ] Document production startup requirements
- [ ] Define rollback strategy

## AWS Readiness

- [ ] Evaluate container hosting options
- [ ] Define production database strategy
- [ ] Plan environment segmentation

## Production Checklist

- [ ] Use non-default secrets
- [ ] Enable secure configuration management
- [ ] Review security headers and CORS settings
- [ ] Validate deployment health checks

## Performance

- [ ] Review query performance
- [ ] Identify hot paths in catalog and order flows
- [ ] Plan caching strategy if needed

## Security Checklist

- [ ] Review authentication and authorization coverage
- [ ] Validate secret storage practices
- [ ] Review dependency vulnerabilities
- [ ] Ensure only necessary ports and services are exposed
