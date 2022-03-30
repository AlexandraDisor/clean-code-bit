package com.endava.app.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.endava.app.entity.Customer;
import com.endava.app.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStatement(@PathVariable("id") String customerId) {

        Customer customer = customerService.getCustomer(customerId);

        return ResponseEntity.ok(customerService.statement(customer));
    }
}
