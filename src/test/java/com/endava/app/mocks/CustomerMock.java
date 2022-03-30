package com.endava.app.mocks;

import java.util.List;

import com.endava.app.entity.Customer;
import com.endava.app.entity.Rental;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerMock {

    public static final int CUSTOMER_ID = 1;
    public static final String CUSTOMER_NAME = "Test";

    public static Customer getCustomer(List<Rental> rentals) {

        return Customer.builder()
                .id(CUSTOMER_ID)
                .name(CUSTOMER_NAME)
                .rentals(rentals)
                .build();
    }


}
