package com.endava.before;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    public static final String MOVIE_REGULAR = "Snatch";
    public static final String MOVIE_NEW_RELEASE = "Fargo";
    public static final int RENTED_DAYS = 3;
    public static final String CUSTOMER_NAME = "Bill";

    private Movie movie = new Movie(MOVIE_REGULAR, Movie.REGULAR);
    private Rental rental = new Rental(movie, RENTED_DAYS);
    private Customer customer = new Customer(CUSTOMER_NAME);

    @BeforeEach
    public void setUp() {
        customer.getRentals().add(rental);
    }

    @Test
    public void test_addRental() {
        assertEquals(rental, customer.getRentals().get(0));
    }

    @Test
    public void test_getName() {
        assertEquals(CUSTOMER_NAME, customer.getName());
    }

    @Test
    public void test_statement() {
        String testResult = "Rental Record for " + CUSTOMER_NAME + "\n\t" +
                MOVIE_REGULAR + "\t3.5" + "\n" +
                "Amount owed is 3.5" + "\n" +
                "You earned 1 frequent renter points";

        String realResult = customer.statement();
        assertEquals(testResult, realResult);
    }
}
