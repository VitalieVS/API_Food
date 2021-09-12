CREATE TABLE promotions
(
    id    int not null,
    title varchar(50),
    body  varchar(255),
    image varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO promotions(id, title, body, image)
VALUES (1, 'New Burgers', 'Try out our new delicious burgers! Buy 2 and receive 3 free',
        'https://media-cldnry.s-nbcnews.com/image/upload/t_fit-2000w,f_auto,q_auto:best/newscms/2019_21/2870431/190524-classic-american-cheeseburger-ew-207p.jpg');
INSERT INTO promotions(id, title, body, image)
VALUES (2, 'Pizza Margheritta', 'Try out our new pizza! Buy 2 and receive 3 free',
        'https://images.ctfassets.net/uexfe9h31g3m/6oBxgSjH9KoYuQqS2uO4Kc/a4b920125e77646ca7a573932a6301d6/GLUTEN-FREE-PIZZA.jpg?w=1024&h=768&fm=webp&fit=thumb&q=90');

INSERT INTO promotions(id, title, body, image)
VALUES (3, 'Black Forest Pancakes', 'Try out our new delicious Black Forest Pancakes!',
        'https://sarahslittlekitchen.files.wordpress.com/2016/03/schwarzwald-pancakes.jpg');


