CREATE TABLE loan (
                      id BIGSERIAL PRIMARY KEY,
                      issue_date TIMESTAMP NOT NULL,
                      due_date TIMESTAMP NOT NULL,
                      return_date TIMESTAMP,
                      status VARCHAR(50) NOT NULL,
                      member_id BIGINT NOT NULL,
                      book_id BIGINT NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      CONSTRAINT fk_loan_member FOREIGN KEY (member_id) REFERENCES member(id),
                      CONSTRAINT fk_loan_book FOREIGN KEY (book_id) REFERENCES book(id)
);

INSERT INTO loan (issue_date, due_date, return_date, status, member_id, book_id, created_at, updated_at) VALUES
                                                                                                           ('2024-06-01 10:00:00', '2024-06-15 10:00:00', NULL, 'ISSUED', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                           ('2024-06-05 11:00:00', '2024-06-19 11:00:00', NULL, 'ISSUED', 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                           ('2024-06-10 12:00:00', '2024-06-24 12:00:00', NULL, 'ISSUED', 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                           ('2024-06-10 12:00:00', '2024-06-24 12:00:00', NULL, 'ISSUED', 4, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                           ('2024-06-10 12:00:00', '2024-06-24 12:00:00', NULL, 'ISSUED', 5, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
