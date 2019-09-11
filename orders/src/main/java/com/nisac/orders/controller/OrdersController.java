package com.nisac.orders.controller;


import com.nisac.orders.model.Customers;
import com.nisac.orders.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController
{

    @Autowired
    private CustomersService customersService;
///http://localhost:5000/orders/order
    @GetMapping(value = "/order", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customers> myCustomers = customersService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping(value ="/name/{name}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName
            (@PathVariable String name)
    {
        Customers customers = customersService.findCustome
    }


}
