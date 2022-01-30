CREATE TABLE promotions
(
    id        int not null,
    title     varchar(50),
    body      varchar(255),
    image     varchar(255),
    food_type varchar(100),
    price     int not null,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO promotions(id, title, body, image, food_type, price)
VALUES (1, 'New sushi set',
        'Try out our new delicious sushi set, which will warm your soul and your stomach, get 2 sets and receive one free, limited promotion',
        'http://10.0.2.2:4546/images/sushi_prom.png', 'Non vegetarian - Salmon', 315);

INSERT INTO promotions(id, title, body, image, food_type, price)
VALUES (2, 'New Chicken Hamburger',
        'Our new Chicken Hamburger will deliver you the best food experience you ever had, with our fresh products and well chosen ingredients will make your tongue suffer of pleasure, get 3 burghers and get one free, limited promotion in stock availability.',
        'http://10.0.2.2:4546/images/hamburger_promo.png', 'Non vegetarian - Meat', 250);

INSERT INTO promotions(id, title, body, image, food_type, price)
VALUES (3, 'Black Forest Pancakes',
        'Try out our new delicious Black Forest Pancakes made fully of love fomr our soul, get one and receive the second completely free!!',
        'http://10.0.2.2:4546/images/pankace.jpg', 'Vegetarian', 55);
