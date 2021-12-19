CREATE TABLE products
(
    product_id     int          not null AUTO_INCREMENT,
    title          varchar(30)  not null,
    price          int          not null,
    is_vegetarian  bool         not null,
    ingredients_id int          not null,
    image_url      varchar(100) not null,
    FOREIGN KEY (ingredients_id) REFERENCES ingredients (ingredient_id),
    PRIMARY KEY (product_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;