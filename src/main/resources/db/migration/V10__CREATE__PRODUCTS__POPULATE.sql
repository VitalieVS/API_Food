CREATE TABLE products
(
    product_id          int          not null AUTO_INCREMENT,
    title               varchar(30)  not null,
    price               int          not null,
    weight              int          not null,
    is_vegetarian       bool         not null,
    image_url           varchar(100) not null,
    product_category_id int          not null,
    FOREIGN KEY (product_category_id) references categories (category_id),
    PRIMARY KEY (product_id),
    quantity            int
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE products_ingredients
(
    product_id    int not null,
    FOREIGN KEY (product_id) REFERENCES products (product_id),
    ingredient_id int not null,
    FOREIGN KEY (ingredient_id) REFERENCES ingredients (ingredient_id)
);

INSERT INTO products (product_id, title, price, weight, is_vegetarian, image_url, product_category_id, quantity)
VALUES (1, 'Chicken', 25, 280, false, 'http://10.0.2.2:4546/images/chicken_hamb.png', 1, 1);

INSERT INTO products (product_id, title, price, weight, is_vegetarian, image_url, product_category_id, quantity)
VALUES (2, 'Black', 25, 300, false, 'http://10.0.2.2:4546/images/black_hamb.png', 1, 1);

INSERT INTO products (product_id, title, price, weight, is_vegetarian, image_url, product_category_id, quantity)
VALUES (3, 'Pepperoni', 75, 500, false, 'http://10.0.2.2:4546/images/pizza_neap.png', 2, 1);

INSERT INTO products (product_id, title, price, weight, is_vegetarian, image_url, product_category_id, quantity)
VALUES (5, 'Philadelphia', 95, 180, false, 'http://10.0.2.2:4546/images/philadelphia.png', 3, 1);


INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (1, 1);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (1, 2);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (1, 3);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (1, 8);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (1, 7);

INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (2, 1);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (2, 9);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (2, 11);


INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (3, 1);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (3, 10);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (3, 11);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (3, 7);


INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (5, 13);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (5, 14);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (5, 15);

CREATE TABLE categories_products
(
    category_id int not null,
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    product_id  int not null,
    FOREIGN KEY (product_id) REFERENCES products (product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO categories_products (category_id, product_id)
VALUES (1, 1);
INSERT INTO categories_products (category_id, product_id)
VALUES (1, 2);
INSERT INTO categories_products (category_id, product_id)
VALUES (2, 3);
INSERT INTO categories_products (category_id, product_id)
VALUES (3, 5);
