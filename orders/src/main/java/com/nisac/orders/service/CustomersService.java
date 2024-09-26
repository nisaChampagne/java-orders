package com.nisac.orders.service;

import com.nisac.orders.model.Customers;
import com.nisac.orders.model.Orders;

import java.util.ArrayList;
import java.util.List;

public interface CustomersService
{
    //get all customers
    ArrayList<Customers> findAll();

    //get orders by name
    Customers findCustomersByName(String name);

    //delete
    void delete(long custCode);

    ///save/create
    Customers save(Customers customers);

    ///put/update
    Customers update(Customers customers, long custCode);
}
