CREATE TABLE matches (
         id SERIAL PRIMARY KEY,
         teamA VARCHAR(255) NOT NULL,
         teamB VARCHAR(255) NOT NULL,
         date VARCHAR(255) NOT NULL,
         location VARCHAR(255) NOT NULL,
         score VARCHAR(255) NOT NULL
);
