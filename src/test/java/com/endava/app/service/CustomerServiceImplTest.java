package com.endava.app.service;

import static com.endava.app.entity.Movie.REGULAR;
import static com.endava.app.mocks.CustomerMock.CUSTOMER_ID;
import static com.endava.app.mocks.CustomerMock.CUSTOMER_NAME;
import static com.endava.app.mocks.CustomerMock.getCustomer;
import static com.endava.app.mocks.MovieMock.MOVIE_REGULAR;
import static com.endava.app.mocks.MovieMock.MOVIE_REGULAR_COPIES;
import static com.endava.app.mocks.MovieMock.getMovie;
import static com.endava.app.mocks.RentalMock.getRental;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.endava.app.entity.Customer;
import com.endava.app.repository.CustomerRepository;
import com.endava.app.service.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {


    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void getCustomer_withValidId_returnsCustomer() {
        when(customerRepository.findCustomerById(CUSTOMER_ID)).thenReturn(new Customer());

        Customer result = customerService.getCustomer(String.valueOf(CUSTOMER_ID));

        assertNotNull(result);
    }

    @Test
    public void getStatement_withValidCustomer_oneRentalsForThreeDays_regularMovie() {
        Customer customer = getCustomer(Collections.singletonList(getRental(3,  getMovie(MOVIE_REGULAR, MOVIE_REGULAR_COPIES, REGULAR))));

        String expectedStatement = "Rental Record for " + CUSTOMER_NAME + "\n\t" +
                MOVIE_REGULAR + "\t3.5" + "\n" +
                "Amount owed is 3.5" + "\n" +
                "You earned 1 frequent renter points";

        final String result = customerService.statement(customer);

        assertEquals(expectedStatement, result);
    }

}
