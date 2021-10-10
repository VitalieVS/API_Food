CREATE TABLE categories
(
    category_id   int         not null auto_increment unique,
    category_name varchar(55) not null,
    product_id    int         not null,
    FOREIGN KEY (product_id) references products (product_id),
    PRIMARY KEY (category_id)
);