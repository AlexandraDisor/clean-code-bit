package com.endava.app.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.endava.app.entity.Customer;
import com.endava.app.entity.Movie;
import com.endava.app.repository.CustomerRepository;
import com.endava.app.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public Customer getCustomer(String id) {
        final Customer customerById = customerRepository.findCustomerById(Integer.valueOf(id));

        return customerById;
    }

    @Override
    public String statement(Customer customer) {
        double totalAmount = 0;
        var frequentRenterPoints = 0;
        var rentals = customer.getRentals();
        var result = "Rental Record for " + customer.getName() + "\n";
        for (var rental : customer.getRentals()) {
            double thisAmount = 0;

            //determine amounts for each line
            switch (rental.getMovie().getPriceCode().getId()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3) thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode().getId() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}
