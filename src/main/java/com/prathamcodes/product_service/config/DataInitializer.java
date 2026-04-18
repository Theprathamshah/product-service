package com.prathamcodes.product_service.config;

import com.prathamcodes.product_service.model.Product;
import com.prathamcodes.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Profile("dev")
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            List<Product> products = List.of(
                new Product(null, "Laptop", 1200.00),
                new Product(null, "Smartphone", 800.00),
                new Product(null, "Tablet", 300.00),
                new Product(null, "Monitor", 150.00),
                new Product(null, "Keyboard", 50.00)
            );
            productRepository.saveAll(products);
            System.out.println("Sample products initialized in H2 database.");
        }
    }
}
