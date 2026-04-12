package com.prathamcodes.product_service;

import com.prathamcodes.product_service.model.Product;
import com.prathamcodes.product_service.service.ProductService;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

		ProductService productService = new ProductService();

		System.out.println("--- All Product Names ---");
		productService.getAllProductNames().forEach(System.out::println);

		double priceThreshold = 500.00;
		System.out.println("\n--- Products Above Price: " + priceThreshold + " ---");
		productService.getProductsAbovePrice(priceThreshold)
				.forEach(p -> System.out.println(p.getName() + ": $" + p.getPrice()));

		System.out.println("\n--- Finding Product by ID 2 ---");
		productService.getProductById(2L).ifPresentOrElse(
				p -> System.out.println("Found: " + p.getName()),
				() -> System.out.println("Product not found")
		);

		System.out.println("\n--- Finding Product by ID 10 ---");
		productService.getProductById(10L).ifPresentOrElse(
				p -> System.out.println("Found: " + p.getName()),
				() -> System.out.println("Product not found")
		);
	}

}
