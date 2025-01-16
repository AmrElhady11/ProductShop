package com.amazon_El8alaba.model;

import com.amazon_El8alaba.entity.CartEntity;
import com.amazon_El8alaba.entity.ProductEntity;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Min(1)
    private int quantity;
    @Min(1)
    private double unitPrice;
    @Min(1)
    private double totalPrice;
    private ProductEntity product;
    private CartEntity cart;

}
