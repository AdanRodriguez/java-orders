package com.lambdaschool.orders.controllers;


import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    //GET http://localhost:2019/customers/customers ---working
    @GetMapping(value = "/customers", produces ={"application/json"})
    public ResponseEntity<?> listAllAgents()
    {
        List<Customer> myList = customerService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
    //GET http:localhost:2019/customers/customers/2
    @GetMapping(value = "/customers/{customerName}", produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable Long customerName)
    {
        Customer c = customerService.findById(customerName);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //POST http:localhost:2019/customers/customers -----working
    @PostMapping(value = "/customers/new", consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer)
    {
        customerService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT http:localhost:2019/customers/customers/2  ------working
    @PutMapping(value = "/customers/{customerid}", consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable long customerid)
    {
        customerService.update(customer, customerid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DELETE http:localhost:2019/customers/customers ----working
    @DeleteMapping("/customers/{customerid}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long customerid)
    {
        customerService.delete(customerid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
