# Spring Boot "Job App" Example Project

This is a sample Java / Maven / Spring Boot (version 1.5.6) application that can be used as a starter for creating a microservice complete with built-in health check, metrics and much more. I hope it helps you.

## How to Run 
```
git clone https://github.com/alimulrazi/Spring-Boot-Job-Application.git
cd first-job-app
git branch -M main
git push -uf origin main
```

### Here are some endpoints you can call:
```
http://localhost:8091/companies
http://localhost:8091/jobs
http://localhost:8091/companies/{companyId}/reviews
```
### Get information about system health, configurations, etc.
```
http://localhost:8091/env
http://localhost:8091/health
http://localhost:8091/info
http://localhost:8091/metrics
```
