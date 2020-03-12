package com.lambdaschool.orders.repos;

import com.lambdaschool.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long>
{
}
