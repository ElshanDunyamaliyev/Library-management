CREATE TABLE category (
                          id BIGSERIAL PRIMARY KEY,
                          category_name VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO category (category_name) VALUES ('Fiction'),('Science Fiction'),('Fantasy'),('Mystery'),('Romance');