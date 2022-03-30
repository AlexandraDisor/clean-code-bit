------------------------ CATEGORIES TABLE ------------------------------------
CREATE TABLE IF NOT EXISTS categories (
                          id INTEGER NOT NULL AUTO_INCREMENT,
                          name VARCHAR(128) NOT NULL,
                          PRIMARY KEY (id)
);

------------------------ MOVIES TABLE ------------------------------------
CREATE TABLE IF NOT EXISTS movies (
                         id INTEGER NOT NULL AUTO_INCREMENT,
                         title VARCHAR(128) NOT NULL,
                         id_category INTEGER NOT NULL,
                         copies INTEGER NOT NULL,
                         PRIMARY KEY (id)
);
ALTER TABLE movies ADD FOREIGN KEY(id_category) REFERENCES categories(id);

------------------------ RENTALS TABLE ------------------------------------
CREATE TABLE IF NOT EXISTS rentals (
                          id INTEGER NOT NULL AUTO_INCREMENT,
                          rental_date DATE NOT NULL,
                          days_rented INTEGER NOT NULL,
                          id_movie INTEGER NOT NULL,
                          PRIMARY KEY (id)
);

ALTER TABLE rentals ADD FOREIGN KEY(id_movie) REFERENCES movies(id);

-- For many-to-many relation add extra table
-- ------------------------ MOVIE_RENTAL TABLE ------------------------------------
-- CREATE TABLE IF NOT EXISTS movie_rental (
--                           id INTEGER NOT NULL AUTO_INCREMENT,
--                           id_movie INTEGER NOT NULL,
--                           id_rental INTEGER NOT NULL,
--                           PRIMARY KEY (id)
-- );
-- ALTER TABLE movie_rental ADD FOREIGN KEY(id_movie) REFERENCES movies(id);
-- ALTER TABLE movie_rental ADD FOREIGN KEY(id_rental) REFERENCES rentals(id);

------------------------ CUSTOMER TABLE ------------------------------------
CREATE TABLE IF NOT EXISTS customers (
                                         id INTEGER NOT NULL AUTO_INCREMENT,
                                         name VARCHAR(128) NOT NULL,
                                         PRIMARY KEY (id)
);

------------------------ MOVIE_RENTAL TABLE ------------------------------------
CREATE TABLE IF NOT EXISTS customer_rental (
                                            id INTEGER NOT NULL AUTO_INCREMENT,
                                            id_customer INTEGER NOT NULL,
                                            id_rental INTEGER NOT NULL,
                                            PRIMARY KEY (id)
);
ALTER TABLE customer_rental ADD FOREIGN KEY(id_customer) REFERENCES customers(id);
ALTER TABLE customer_rental ADD FOREIGN KEY(id_rental) REFERENCES rentals(id);


