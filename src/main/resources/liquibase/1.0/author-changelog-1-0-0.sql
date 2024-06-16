CREATE TABLE author (
                        id BIGSERIAL PRIMARY KEY,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        birth_date INT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO author (first_name, last_name, birth_date) VALUES ('John', 'Doe', 1970),('Jane', 'Smith', 1985),
('Michael', 'Johnson', 1992),('Emily', 'Brown', 1978),('David', 'Williams', 1980);
