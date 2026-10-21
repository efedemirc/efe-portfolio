# efe-portfolio

My personal portfolio website, built as a real full stack application rather than a static page:
the content lives in a database and is served by a REST API.

**Stack:** Java 21, Spring Boot 4, PostgreSQL, Flyway, React, TypeScript, Vite, Docker, GitHub Actions

> Work in progress. Planned next: experience and projects sections, an admin panel with JWT login,
> CV download generated as PDF on the server, contact form with rate limiting, and integration tests
> with Testcontainers.

## Architecture

```
browser ──> nginx (React build) ──/api──> Spring Boot ──> PostgreSQL
```

- `backend/` Spring Boot REST API. Flyway manages the database schema.
- `frontend/` React + TypeScript single page app, built with Vite.
- In development, Vite proxies `/api` to the backend; in Docker, nginx does the same.

## Run it

Requires Docker.

```bash
cp .env.example .env   # then edit the values
docker compose up --build
```

- Website: http://localhost:3000
- API: http://localhost:8080/api/profile
- Health check: http://localhost:8080/actuator/health

## Develop locally

```bash
docker compose up db                 # database only
cd backend && mvn spring-boot:run    # API on :8080
cd frontend && npm install && npm run dev   # site on :5173
```

## Secrets

No secret is ever committed. All credentials are read from environment variables;
`.env` is git-ignored and `.env.example` only lists the variable names.
