package com.amazon_El8alaba.dao;

import com.amazon_El8alaba.entity.ProductDetailsEntity;
import com.amazon_El8alaba.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository  {

    ProductEntity insert(ProductDetailsEntity productDetails);
    ProductEntity findById(int id);
    void deleteById(int id);
    void update(ProductDetailsEntity productDetails);
    List<ProductEntity> findAll();
    ProductDetailsEntity findProductDetailsById(int id);
}
