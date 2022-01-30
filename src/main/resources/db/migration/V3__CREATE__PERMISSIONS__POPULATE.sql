CREATE TABLE permissions
(
    permission_id int(11) NOT NULL AUTO_INCREMENT,
    name          VARCHAR(255) NOT NULL,
    PRIMARY KEY (permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO permissions(permission_id, name)
VALUES (1, '/user/**');
INSERT INTO permissions(permission_id, name)
VALUES (2, '/createOrder');