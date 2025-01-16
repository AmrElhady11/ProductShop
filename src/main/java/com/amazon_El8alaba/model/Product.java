package com.amazon_El8alaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private String manufacturer;
    private LocalDateTime productionTime;
    private LocalDateTime expirationDate;
    private double unitPrice;
    private int quantity;
    private boolean availability;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;
}
