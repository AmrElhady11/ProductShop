package com.amazon_El8alaba.service;

import com.amazon_El8alaba.dao.ProductRepository;
import com.amazon_El8alaba.model.Product;
import com.amazon_El8alaba.model.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
 boolean addProduct(ProductDetails productDetails);
 List<Product> getAllProduct ();
 boolean updateProduct(ProductDetails productDetails);
 boolean deleteProduct(int id);
 ProductDetails getProductDetails(int id);

}
