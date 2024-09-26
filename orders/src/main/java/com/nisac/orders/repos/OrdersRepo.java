package com.nisac.orders.repos;

import com.nisac.orders.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders, Long>
{
}
