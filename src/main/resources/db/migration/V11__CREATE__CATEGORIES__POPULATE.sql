CREATE TABLE categories
(
    category_id   int         not null auto_increment unique,
    category_name varchar(55) not null,
    PRIMARY KEY (category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO categories(category_id, category_name)
VALUES (1, 'Burgers');

INSERT INTO categories(category_id, category_name)
VALUES (2, 'Pizza');

INSERT INTO categories(category_id, category_name)
VALUES (3, 'Sushi');

