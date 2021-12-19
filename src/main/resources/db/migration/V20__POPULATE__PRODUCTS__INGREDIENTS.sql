INSERT INTO products (product_id, title, price, ingredients_id, image_url)
VALUES (1, 'Chicken', 25, 1, 'http://10.0.2.2:4546/images/chicken_burger.jpg');

INSERT INTO products (product_id, title, price, ingredients_id, image_url)
VALUES (2, 'Black', 25, 4, 'http://10.0.2.2:4546/images/black_burger.jpg');

INSERT INTO products (product_id, title, price, ingredients_id, image_url)
VALUES (3, 'Pepperoni', 75, 2, 'http://10.0.2.2:4546/images/pepperoni_pizza.png');

INSERT INTO products (product_id, title, price, ingredients_id, image_url)
VALUES (4, 'Neapolitan', 80, 3, 'http://10.0.2.2:4546/images/chicken_burger.png');


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
VALUES (4, 1);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (4, 12);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (4, 3);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (4, 8);
INSERT INTO products_ingredients (product_id, ingredient_id)
VALUES (4, 7);


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
