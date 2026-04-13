package com.prathamcodes.product_service.service;

import com.prathamcodes.product_service.dto.ProductDTO;
import com.prathamcodes.product_service.exception.ResourceNotFoundException;
import com.prathamcodes.product_service.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 6L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product createProduct(ProductDTO dto) {
        Product product = new Product(nextId++, dto.getName(), dto.getPrice());
        products.add(product);
        return product;
    }

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

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }
}
