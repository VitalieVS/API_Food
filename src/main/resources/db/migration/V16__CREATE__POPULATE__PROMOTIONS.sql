CREATE TABLE promotions
(
    id        int not null,
    title     varchar(50),
    body      varchar(255),
    image     varchar(255),
    food_type varchar(100),
    price     int not null,
    PRIMARY KEY (id)
);

INSERT INTO promotions(id, title, body, image, food_type, price)
VALUES (1, 'New Burgers', 'Try out our new delicious burgers! Buy 2 and receive 3 free',
        'http://10.0.2.2:4546/images/burgers.jpg', 'Non vegetarian - Eggs', 85);

INSERT INTO promotions(id, title, body, image, food_type, price)
VALUES (2, 'Pizza 4 cheeses', 'Try out our new pizza! Buy 2 and receive 3 free',
        'http://10.0.2.2:4546/images/4cheese.jpg', 'Vegetarian pizza cheese', 125);

INSERT INTO promotions(id, title, body, image, food_type, price)
VALUES (3, 'Black Forest Pancakes', 'Try out our new delicious Black Forest Pancakes!',
        'http://10.0.2.2:4546/images/pankace.jpg', 'Non vegetarian - Eggs', 39);


