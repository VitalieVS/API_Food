CREATE TABLE promotions
(
    id    int not null,
    title varchar(50),
    body  varchar(255),
    image varchar(100),
    PRIMARY KEY (id)
);

INSERT INTO promotions(id, title, body, image)
VALUES (1, 'New Burgers', 'Try out our new delicious burgers! Buy 2 and receive 3 free', 'not_yet');
INSERT INTO promotions(id, title, body, image)
VALUES (2, 'Pizza Margheritta', 'Try out our new pizza! Buy 2 and receive 3 free', 'not_yet');