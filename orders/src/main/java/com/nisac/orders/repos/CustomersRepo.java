package com.nisac.orders.repos;

import com.nisac.orders.model.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<Customers, Long>
{

}
