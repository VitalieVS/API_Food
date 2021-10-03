CREATE TABLE ingredients
(
    ingredient_id int not null AUTO_INCREMENT,
    name          varchar(30),
    PRIMARY KEY (ingredient_id)
);

INSERT INTO ingredients (ingredient_id, name)
VALUES (1, 'Eggs');
INSERT INTO ingredients (ingredient_id, name)
VALUES (2, 'Bread');
INSERT INTO ingredients (ingredient_id, name)
VALUES (3, 'Milk');
INSERT INTO ingredients (ingredient_id, name)
VALUES (4, 'Chicken meat');
INSERT INTO ingredients (ingredient_id, name)
VALUES (5, 'Beef');
INSERT INTO ingredients (ingredient_id, name)
VALUES (6, 'Potatoes');
INSERT INTO ingredients (ingredient_id, name)
VALUES (7, 'Tomatoes');
INSERT INTO ingredients (ingredient_id, name)
VALUES (8, 'Ketchup');
INSERT INTO ingredients (ingredient_id, name)
VALUES (9, 'Pepperoni');
INSERT INTO ingredients (ingredient_id, name)
VALUES (10, 'Bacon');
