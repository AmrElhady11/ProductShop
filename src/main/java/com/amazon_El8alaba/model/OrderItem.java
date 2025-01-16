package com.amazon_El8alaba.model;

import com.amazon_El8alaba.entity.CartEntity;
import com.amazon_El8alaba.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private ProductEntity product;
    private CartEntity cart;

}
