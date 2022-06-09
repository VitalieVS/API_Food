CREATE TABLE categories
(
    category_id   int          not null auto_increment unique,
    category_name varchar(55)  not null,
    PRIMARY KEY (category_id),
    image_url     varchar(200) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO categories(category_id, category_name, image_url)
VALUES (1, 'Burgers', 'http://10.0.2.2:4546/images/burger_category.png');

INSERT INTO categories(category_id, category_name, image_url)
VALUES (2, 'Pizza', 'http://10.0.2.2:4546/images/pizza_category.png');

INSERT INTO categories(category_id, category_name, image_url)
VALUES (3, 'Rolls', 'http://10.0.2.2:4546/images/sushi_category.png');

