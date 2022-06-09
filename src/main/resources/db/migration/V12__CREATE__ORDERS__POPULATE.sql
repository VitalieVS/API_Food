CREATE TABLE orders
(
    order_id          int not null unique AUTO_INCREMENT,
    PRIMARY KEY (order_id),
    total_price       double,
    order_date        date,
    order_status      varchar(50),
    image_url         varchar(250),
    payment_method    varchar(100),
    cash_back_applied double
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE users_orders
(
    order_id int not null,
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    user_id  int not null,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE products_orders
(
    order_id   int not null,
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    product_id int not null,
    FOREIGN KEY (product_id) REFERENCES products (product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE promotions_orders
(
    order_id     int not null,
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    promotion_id int not null,
    FOREIGN KEY (promotion_id) REFERENCES promotions (promotion_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;