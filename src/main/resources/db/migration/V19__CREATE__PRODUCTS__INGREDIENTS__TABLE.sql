CREATE TABLE products_ingredients
(
    product_id    int not null,
    FOREIGN KEY (product_id) REFERENCES products (product_id),
    ingredient_id int not null,
    FOREIGN KEY (ingredient_id) REFERENCES ingredients (ingredient_id)
);