package com.nisac.orders.controller;


import com.nisac.orders.model.Customers;
import com.nisac.orders.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class OrdersController
{

    @Autowired
    private CustomersService customersService;


///http://localhost:5000/customers/customer
    @GetMapping(value = "/customer", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        ArrayList<Customers> myCustomers = customersService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
//http://localhost:5000/customers/customer/name/{name}
    @GetMapping(value ="customer/name/{name}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName
            (@PathVariable String name)
    {
        Customers customer = customersService.findCustomersByName(name);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    ////http://localhost:5000/customers/new
    @PostMapping(value = "/new", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer)
    {
        newCustomer = customersService.save((newCustomer));

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{customerid}")
                .buildAndExpand(newCustomer.getCustCode()).toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null,responseHeaders,HttpStatus.CREATED);
    }
////http://localhost:5000/customers/update/{custcode}
    @PutMapping(value = "/update/{custcode}")
    public ResponseEntity<?> updateCustomerById(@RequestBody Customers updateCustomer, @PathVariable long custcode)
    {
        customersService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    ////http://localhost:5000/customers/delete/{custcode}
    @DeleteMapping(value = "/delete/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customersService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
