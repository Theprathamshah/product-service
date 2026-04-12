package com.prathamcodes.product_service.service;

import com.prathamcodes.product_service.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Laptop", 1200.00));
        products.add(new Product(2L, "Smartphone", 800.00));
        products.add(new Product(3L, "Tablet", 300.00));
        products.add(new Product(4L, "Monitor", 150.00));
        products.add(new Product(5L, "Keyboard", 50.00));
    }

    public List<Product> getProductsAbovePrice(double price) {
        return products.stream()
                .filter(p -> p.getPrice() > price)
                .toList();
    }

    public List<String> getAllProductNames() {
        return products.stream()
                .map(Product::getName)
                .toList();
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
