CREATE TABLE roles_permissions
(
    role_id       int not null,
    permission_id int not null,
    FOREIGN KEY (role_id) REFERENCES roles (role_id),
    FOREIGN KEY (permission_id) REFERENCES permissions (permission_id)
)