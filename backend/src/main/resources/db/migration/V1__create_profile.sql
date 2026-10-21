CREATE TABLE profile (
    id           BIGINT PRIMARY KEY,
    full_name    VARCHAR(120) NOT NULL,
    headline     VARCHAR(200) NOT NULL,
    summary      TEXT         NOT NULL,
    location     VARCHAR(120),
    email        VARCHAR(200),
    github_url   VARCHAR(300),
    linkedin_url VARCHAR(300)
);

INSERT INTO profile (id, full_name, headline, summary, location, email, github_url, linkedin_url)
VALUES (
    1,
    'Efe Demir Civelek',
    'Full Stack Developer | Java, Spring Boot, React, TypeScript',
    'Full stack developer with production experience at a German PropTech company, '
        || 'building features for a facility management platform. B.Sc. in Software Engineering, '
        || 'with a thesis on machine learning for speech disorder detection.',
    'Potsdam, Germany',
    'efedemircivelek@gmail.com',
    'https://github.com/efedemirc',
    NULL
);
