CREATE TABLE News (
    id SERIAL NOT NULL,
    original_text TEXT,
    formatted_text TEXT,
    url TEXT,
    timestamp TIMESTAMP WITHOUT TIME ZONE
);
