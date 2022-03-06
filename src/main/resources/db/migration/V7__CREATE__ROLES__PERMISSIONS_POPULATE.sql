CREATE TABLE roles_permissions
(
    role_id       int not null,
    permission_id int not null,
    FOREIGN KEY (role_id) REFERENCES roles (role_id),
    FOREIGN KEY (permission_id) REFERENCES permissions (permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO roles_permissions(role_id, permission_id)
VALUES (1, 1);
INSERT INTO roles_permissions(role_id, permission_id)
VALUES (2, 1);

INSERT INTO roles_permissions(role_id, permission_id)
VALUES (2, 2);
INSERT INTO roles_permissions(role_id, permission_id)
VALUES (1, 2);

INSERT INTO roles_permissions(role_id, permission_id)
VALUES (2, 3);
INSERT INTO roles_permissions(role_id, permission_id)
VALUES (1, 3);
