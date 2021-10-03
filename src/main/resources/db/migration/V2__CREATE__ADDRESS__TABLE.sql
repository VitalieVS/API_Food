CREATE TABLE addresses
(
    address_id     int AUTO_INCREMENT,
    PRIMARY KEY (address_id),
    first_address  varchar(100),
    second_address varchar(100),
    city           varchar(30),
    country        varchar(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;