CREATE TABLE problem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    difficulty enum('EASY', 'MEDIUM', 'HARD'),
    dateCreated DATE,
    updatedAt DATE
);

CREATE TABLE problem_description (
    id BIGINT PRIMARY KEY,
    description TEXT,
    examples TEXT,
    constraints TEXT,
    FOREIGN KEY (id) REFERENCES problem(id)
);

CREATE TABLE problem_social_interaction (
    id BIGINT PRIMARY KEY,
    likes BIGINT,
    dislikes BIGINT,
    saves BIGINT,
    FOREIGN KEY (id) REFERENCES problem(id)
);

CREATE TABLE tag (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE problem_tag (  
    problem_id BIGINT NOT NULL, 
    tag_id BIGINT NOT NULL,
    PRIMARY KEY (problem_id, tag_id),
    FOREIGN KEY (problem_id) REFERENCES problem(id),
    FOREIGN KEY (tag_id) REFERENCES tag(id)
);

CREATE TABLE comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    problem_id BIGINT NOT NULL,
    FOREIGN KEY (problem_id) REFERENCES problem(id)
);

CREATE TABLE rating (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    score BIGINT NOT NULL,
    problem_id BIGINT NOT NULL,
    FOREIGN KEY (problem_id) REFERENCES problem(id)
);

