package com.amazon_El8alaba.dao;

import com.amazon_El8alaba.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
