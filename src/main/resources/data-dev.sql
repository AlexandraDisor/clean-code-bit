INSERT INTO categories (id, name) VALUES (1, 'Regular');
INSERT INTO categories (id, name) VALUES (2, 'New Release');
INSERT INTO categories (id, name) VALUES (3, 'Children');

INSERT INTO movies (id, title, id_category, copies) VALUES (1, 'Snatch', 1, 10);
INSERT INTO movies (id, title, id_category, copies) VALUES (2, 'Fargo', 1, 17);
INSERT INTO movies (id, title, id_category, copies) VALUES (3, 'Dune', 2, 25);
INSERT INTO movies (id, title, id_category, copies) VALUES (4, 'Coco', 3, 10);

INSERT INTO rentals (id, rental_date, days_rented, id_movie) VALUES (1, CURRENT_DATE, 3, 1);
INSERT INTO rentals (id, rental_date, days_rented, id_movie) VALUES (2, CURRENT_DATE, 3, 3);
INSERT INTO rentals (id, rental_date, days_rented, id_movie) VALUES (3, CURRENT_DATE, 3, 4);

INSERT INTO customers (id, name, fidelity_points) VALUES (1, 'John Lew', 20);

INSERT INTO customer_rental (id, id_customer, id_rental) VALUES (1, 1, 1);
INSERT INTO customer_rental (id, id_customer, id_rental) VALUES (2, 1, 2);
INSERT INTO customer_rental (id, id_customer, id_rental) VALUES (3, 1, 3);




