CREATE TABLE users_role
(
    user_id int not null,
    PRIMARY KEY (user_id),
    role_id int not null,
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);