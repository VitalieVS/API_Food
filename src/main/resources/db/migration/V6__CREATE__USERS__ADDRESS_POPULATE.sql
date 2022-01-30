CREATE TABLE users_address
(
    user_id    int not null,
    PRIMARY KEY (user_id),
    address_id int not null,
    FOREIGN KEY (address_id) REFERENCES addresses (address_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO users_address(address_id, user_id)
VALUES (1, 1);
INSERT INTO users_address(address_id, user_id)
VALUES (2, 2);