CREATE TABLE users
(
    user_id           int          not null unique AUTO_INCREMENT,
    PRIMARY KEY (user_id),
    name              varchar(50)  not null,
    surname           varchar(50)  not null,
    email             varchar(100) not null unique,
    password          varchar(250) not null,
    total_spent_money DOUBLE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO users(user_id, name, surname, email, password, total_spent_money)
VALUES (1, 'Ion', 'Lungu', 'ion.lungu@gmail.com', '$2a$12$Ofcb4yYdRXd.pmZgJIX7..vJGRDnDq97qYmtmbgBqKQvlVTSYtOXa', 0);

INSERT INTO users(user_id, name, surname, email, password, total_spent_money)
VALUES (2, 'Banari', 'Vlad', 'banarivlad@gmail.com', '$2a$12$6Vr1O2Iz9qEVi3NwWGoNZ.Vs1Lgr7PAvA6fyGef6zIePFlNAP2joi', 0);

