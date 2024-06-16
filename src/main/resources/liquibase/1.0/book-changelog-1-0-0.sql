CREATE TABLE book (
                      id BIGSERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      total_page INT,
                      published_year INT,
                      publisher_id BIGINT,
                      category_id BIGINT,
                      author_id BIGINT,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      CONSTRAINT fk_book_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(id),
                      CONSTRAINT fk_book_category FOREIGN KEY (category_id) REFERENCES category(id),
                      CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author(id)
);
INSERT INTO book (title, description, total_page, published_year, publisher_id, category_id, author_id)
VALUES ('Book 1', 'Description for Book 1.', 250, 2010, 1, 1, 1),('Book 2', 'Description for Book 2.', 320, 2015, 2, 2, 2),
       ('Book 3', 'Description for Book 3.', 280, 2012, 3, 3, 3),('Book 4', 'Description for Book 4.', 300, 2018, 4, 4, 4),
       ('Book 5', 'Description for Book 5.', 350, 2021, 5, 5, 5);
