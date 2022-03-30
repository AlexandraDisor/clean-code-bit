package com.endava.app.service;

import com.endava.app.entity.Customer;

public interface CustomerService {

    Customer getCustomer(String id);

    String statement(Customer customer);
}
