CREATE TABLE users_address
(
    user_id    int not null,
    PRIMARY KEY (user_id),
    address_id int not null,
    FOREIGN KEY (address_id) REFERENCES addresses (address_id)
)