INSERT INTO categories(category_id, category_name, product_id)
VALUES (1, 'Burgers', 1);

INSERT INTO categories(category_id, category_name, product_id)
VALUES (2, 'Pizza', 1);

INSERT INTO categories(category_id, category_name, product_id)
VALUES (3, 'Sushi', 5);

INSERT INTO categories_products (category_id, product_id)
VALUES (1, 1);
INSERT INTO categories_products (category_id, product_id)
VALUES (1, 2);
INSERT INTO categories_products (category_id, product_id)
VALUES (2, 3);
INSERT INTO categories_products (category_id, product_id)
VALUES (2, 4);
INSERT INTO categories_products (category_id, product_id)
VALUES (3, 5);
