CREATE TABLE roles
(
    role_id        int         NOT NULL AUTO_INCREMENT,
    role_name      VARCHAR(30) NOT NULL,
    PRIMARY KEY (role_id),
    permissions_id int,
    FOREIGN KEY (permissions_id) REFERENCES permissions (permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO roles(role_id, role_name, permissions_id)
VALUES (1, 'USER', 1);
INSERT INTO roles(role_id, role_name, permissions_id)
VALUES (2, 'ADMIN', 1);
