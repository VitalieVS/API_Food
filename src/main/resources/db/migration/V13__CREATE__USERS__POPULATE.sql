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

INSERT INTO users(user_id, name, surname, email, address_id, password, role_id)
VALUES (1, 'Ion', 'Lungu', 'ion.lungu@gmail.com', 1, '$2a$12$Ofcb4yYdRXd.pmZgJIX7..vJGRDnDq97qYmtmbgBqKQvlVTSYtOXa', 1);

INSERT INTO users(user_id, name, surname, email, address_id, password, role_id)
VALUES (2, 'Banari', 'Vlad', 'banarivlad@gmail.com', 2, '$2a$12$6Vr1O2Iz9qEVi3NwWGoNZ.Vs1Lgr7PAvA6fyGef6zIePFlNAP2joi',
        2);

