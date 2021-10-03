CREATE TABLE products
(
    product_id     int          not null AUTO_INCREMENT,
    title          varchar(30)  not null,
    price          int          not null,
    ingredients_id int          not null,
    image_url      varchar(100) not null,
    FOREIGN KEY (ingredients_id) REFERENCES ingredients (ingredient_id),
    PRIMARY KEY (product_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


#
# INSERT INTO products_ingredients (product_id, ingredients_id) VALUES (1,1);
#
# INSERT INTO products (product_id, title, price, ingredients_id, image_url)
# VALUES (1, 'Chicken Burger', 25, 1, 'chicken_burger.png');