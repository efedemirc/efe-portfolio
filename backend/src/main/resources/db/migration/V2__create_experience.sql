CREATE TABLE experience (
    id          BIGSERIAL PRIMARY KEY,
    company     VARCHAR(150) NOT NULL,
    role        VARCHAR(150) NOT NULL,
    location    VARCHAR(120),
    start_date  DATE         NOT NULL,
    end_date    DATE,                     -- NULL = current position
    description TEXT         NOT NULL,    -- one bullet point per line
    CONSTRAINT chk_experience_dates CHECK (end_date IS NULL OR end_date >= start_date)
);

INSERT INTO experience (company, role, location, start_date, end_date, description)
VALUES
    (
        'Solutiance AG',
        'Working Student, Full Stack Development',
        'Potsdam, Germany',
        DATE '2026-04-01',
        DATE '2026-10-02',
        'Developed features for the FacilityScanner web app (React, TypeScript, MobX), including multi-select defect resolution and Excel export with Apache POI
Worked on PDF report generation in the Roofus module (Java/Spring, Handlebars)
Set up an AI-assisted, test-driven development workflow for a new backend service (Java 17, Hibernate, MariaDB, MongoDB), with separate agents for writing and breaking tests and human review of every commit; the pilot surfaced real bugs before release'
    ),
    (
        'Solutiance AG',
        'AI Intern, Workflow Optimization',
        'Potsdam, Germany',
        DATE '2025-09-01',
        DATE '2026-02-28',
        'Workflow optimization and prompt engineering for internal processes
Built a deep learning prototype for detecting fraudulent content in financial documents (Python, PyTorch)'
    );