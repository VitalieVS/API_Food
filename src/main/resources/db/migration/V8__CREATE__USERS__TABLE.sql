CREATE TABLE users(
                      user_id    int          not null unique AUTO_INCREMENT,
                      PRIMARY KEY (user_id),
                      name       varchar(50)  not null,
                      surname    varchar(50)  not null,
                      email      varchar(100) not null unique,
                      address_id int,
                      FOREIGN KEY (address_id) REFERENCES addresses (address_id),
                      password   varchar(250) not null,
                      role_id    int,
                      FOREIGN KEY (role_id) REFERENCES roles (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
