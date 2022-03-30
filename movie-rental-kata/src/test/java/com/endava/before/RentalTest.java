package com.endava.before;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {

    public static final String MOVIE_REGULAR = "Snatch";

    private Movie movie = new Movie(MOVIE_REGULAR, Movie.REGULAR);
    private Rental rental = new Rental(movie, 3);

    @Test
    public void test_getMovie() {
        assertEquals(movie, rental.getMovie());
    }

    @Test
    public void test_getDaysRented() {
        assertEquals(rental.getDaysRented(), 3);
    }
}
