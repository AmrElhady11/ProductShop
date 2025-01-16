package com.amazon_El8alaba.dao;

import com.amazon_El8alaba.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartEntity, Integer> {
}
