package com.prathamcodes.product_service.service;

import com.prathamcodes.product_service.dto.ProductDTO;
import com.prathamcodes.product_service.exception.ResourceNotFoundException;
import com.prathamcodes.product_service.model.Product;
import com.prathamcodes.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    public List<Product> getProductsAbovePrice(double price) {
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() > price)
                .toList();
    }

    public List<String> getAllProductNames() {
        return productRepository.findAll().stream()
                .map(Product::getName)
                .toList();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }
}
