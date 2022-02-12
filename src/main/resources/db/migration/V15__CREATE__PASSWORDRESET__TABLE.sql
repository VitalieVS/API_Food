CREATE TABLE passwordreset
(
    reset_id int          not null unique AUTO_INCREMENT,
    PRIMARY KEY (reset_id),
    token    varchar(250) not null,
    user_id  int          not null,
    FOREIGN KEY (user_id) REFERENCES users (user_id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;