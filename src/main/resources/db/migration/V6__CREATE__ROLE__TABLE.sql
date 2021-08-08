CREATE TABLE roles
(
    role_id int(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    PRIMARY KEY (role_id),
    permissions_id int,
    FOREIGN KEY (permissions_id) REFERENCES permissions(permission_id)
);
