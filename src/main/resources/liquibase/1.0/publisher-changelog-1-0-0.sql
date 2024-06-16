CREATE TABLE publisher (
                           id BIGSERIAL PRIMARY KEY,
                           publisher_name VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO publisher (publisher_name) VALUES ('Penguin Books'),('HarperCollins'),('Random House'),
                                              ('Simon & Schuster'),('Macmillan Publishers');
