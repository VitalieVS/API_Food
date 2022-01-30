CREATE TABLE ingredients
(
    ingredient_id   int not null AUTO_INCREMENT,
    ingredient_name varchar(30),
    PRIMARY KEY (ingredient_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (1, 'Eggs');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (2, 'Bread');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (3, 'Milk');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (4, 'Chicken meat');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (5, 'Beef');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (6, 'Potatoes');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (7, 'Tomatoes');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (8, 'Ketchup');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (9, 'Pepperoni');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (10, 'Bacon');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (11, 'Cheese');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (12, 'Black Bread');

INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (13, 'Philadelphia cheese');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (14, 'Smoked salmon');
INSERT INTO ingredients (ingredient_id, ingredient_name)
VALUES (15, 'Rice');