package com.lambdaschool.orders.controllers;


import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    //GET http:localhost:2019/customers/customers
    @GetMapping(value = "/customers", produces ={"application/json"})
    public ResponseEntity<?> listAllAgents()
    {
        List<Customer> myList = customerService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
    //GET http:localhost:2019/customers/customers/2

    //POST http:localhost:2019/customers/customers

    //PUT http:localhost:2019/customers/customers/2

    //DELETE http:localhost:2019/customers/customers


}
