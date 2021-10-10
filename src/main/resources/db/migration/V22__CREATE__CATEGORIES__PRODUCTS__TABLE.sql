CREATE TABLE categories_products
(
    category_id int not null,
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    product_id  int not null,
    FOREIGN KEY (product_id) REFERENCES products (product_id)
);