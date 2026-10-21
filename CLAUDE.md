# CLAUDE.md

Personal portfolio website: a CV-style site backed by a real full stack application.
The owner (Efe) uses this project to practice for interviews, so how work is split matters.

## Stack

- Backend: Java 21, Spring Boot 4.1, Spring Data JPA, PostgreSQL, Flyway (`backend/`)
- Frontend: React + TypeScript, Vite, oxlint (`frontend/`)
- Infra: Docker Compose, nginx (serves the frontend and proxies `/api`), GitHub Actions
- Owner's machine: Windows 11, VS Code, PowerShell

## Commands

- Database only: `docker compose up -d db`
- Backend: `cd backend && ./mvnw spring-boot:run` (Windows: `.\mvnw.cmd spring-boot:run`)
- Backend tests: `cd backend && ./mvnw verify`
- Frontend: `cd frontend && npm install && npm run dev` (http://localhost:5173)
- Frontend checks: `npm run lint && npm run build`
- Full stack: `docker compose up --build` (http://localhost:3000)

## Working agreement

- Efe writes feature code himself (CRUD endpoints, React components). When asked about
  these, give hints and review his code; do not hand over complete solutions unless he asks.
- Claude may write infrastructure and harder parts (security/JWT, PDF generation,
  Testcontainers, deployment), always on a separate branch with a pull request.
  Efe reviews every change before merging. Never push to `main` directly.
- One feature per branch (`feature/<name>`), one pull request per feature.

## Conventions

- Backend packages are organized by feature: `com.efedemirc.portfolio.<feature>` containing
  entity, repository, service, controller and a response record. The API returns records,
  never entities.
- Flyway owns the schema (`ddl-auto: validate`). Never edit an applied migration;
  every change is a new `V<n>__description.sql` in `backend/src/main/resources/db/migration`.
- Use `Locale.ROOT` for `toUpperCase` / `toLowerCase` (the dev machine locale is `tr_TR`).
- Site content is in English.

## Rules

- No secrets in the repository. Configuration comes from environment variables;
  `.env` is git-ignored and `.env.example` lists names only. API keys (for example an LLM key)
  are used only by the backend, never in frontend code.
- No phone number anywhere on the site or in the repository.
- Do not mention confidential work from previous employers (internal service names,
  internal systems). Public product names already on the owner's LinkedIn are fine.
- Do not inflate claims on the site; every statement must match the owner's CV and references.

## Roadmap

profile (done) → experience → projects → skills → contact form with rate limiting →
admin panel with JWT login → CV PDF download → Testcontainers tests → deployment →
optional LLM chatbot (key only in the backend)