package com.amazon_El8alaba.model;

import com.amazon_El8alaba.entity.ProductDetailsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String name;
    ProductDetailsEntity productDetails ;
}
