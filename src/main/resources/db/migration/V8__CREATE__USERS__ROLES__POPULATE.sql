CREATE TABLE users_role
(
    user_id int not null,
    PRIMARY KEY (user_id),
    role_id int not null,
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO users_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_role (user_id, role_id)
VALUES (2, 2);