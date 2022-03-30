package com.endava.before;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    public static final String MOVIE_REGULAR = "Snatch";
    private Movie movie = new Movie(MOVIE_REGULAR, Movie.REGULAR);

    @Test
    public void test_getMovieTitle() {
        assertEquals(MOVIE_REGULAR, movie.getTitle());
    }

    @Test
    public void test_getPriceCode() {
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }
}
