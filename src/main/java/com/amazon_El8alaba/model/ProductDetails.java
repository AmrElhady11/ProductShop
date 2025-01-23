package com.amazon_El8alaba.model;

import com.amazon_El8alaba.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
    private Integer id;
    private ProductEntity productId;
    private String name;
    private LocalDate expirationDate;
    private String manufacturer;
    private Double price;
    private Boolean available ;
}
