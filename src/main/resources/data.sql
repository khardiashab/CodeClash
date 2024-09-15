-- Insert dummy data into Problem table
INSERT INTO problem (id, title, difficulty, dateCreated, updatedAt)
VALUES
    (1, 'Sample Problem 1', 'EASY', CURRENT_DATE, CURRENT_DATE),
    (2, 'Sample Problem 2', 'MEDIUM', CURRENT_DATE, CURRENT_DATE);

-- Insert dummy data into ProblemDescription table
INSERT INTO problem_description (id, description, examples, constraints)
VALUES
    (1, 'Description for Problem 1', 'Example 1', 'Constraint 1'),
    (2, 'Description for Problem 2', 'Example 2', 'Constraint 2');

-- Insert dummy data into ProblemSocialInteraction table
INSERT INTO problem_social_interaction (id, likes, dislikes, saves)
VALUES
    (1, 100, 5, 50),
    (2, 200, 10, 75);

-- Insert dummy data into Tag table
INSERT INTO tag (id, name)
VALUES
    (1, 'Sample Tag 1'),
    (2, 'Sample Tag 2');

-- Insert dummy data into ProblemTag table
INSERT INTO problem_tag (problem_id, tag_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1);

-- -- Insert dummy data into Comment table (assuming it has been created)
INSERT INTO comment (id, text, problem_id)
VALUES
    (1, 'Great problem!', 1),
    (2, 'Needs more examples.', 2);

-- -- Insert dummy data into Rating table (assuming it has been created)
INSERT INTO rating (id, score, problem_id)
VALUES
    (1, 5, 1),
    (2, 4, 2);
