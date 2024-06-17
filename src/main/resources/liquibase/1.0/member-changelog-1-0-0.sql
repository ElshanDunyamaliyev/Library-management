CREATE TABLE member (
                        id BIGSERIAL PRIMARY KEY,
                        username VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        role VARCHAR(50) NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO member (username, email, password, role, created_at, updated_at) VALUES
                                                                                 ('samir', 'samir@example.com', 'password1', 'ROLE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                 ('ferid', 'ferid@example.com', 'password2', 'ROLE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                 ('admin', 'admin@example.com', 'adminpassword', 'ROLE_ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                 ('mehemmed', 'mehemmed@example.com', 'password4', 'ROLE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                 ('kenan', 'kenan@example.com', 'password5', 'ROLE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
