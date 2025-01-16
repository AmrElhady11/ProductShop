package com.amazon_El8alaba.dao;

import com.amazon_El8alaba.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
