package com.popovich.service;

import com.popovich.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(Long id);
    Product getProductById(Long id);
    List<Product> getProducts();
}
