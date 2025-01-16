package com.amazon_El8alaba.dao;

import com.amazon_El8alaba.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
}
