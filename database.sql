CREATE TABLE News (
    id SERIAL NOT NULL,
    content TEXT,
    accuracy FLOAT,
    algorithm ENUM ('cosine', 'levenshtein', 'jaro-winkler'),
    created_at TIMESTAMP(0) WITHOUT TIMEZONE,
    updated_at TIMESTAMP(0) WITHOUT TIMEZONE,
);
