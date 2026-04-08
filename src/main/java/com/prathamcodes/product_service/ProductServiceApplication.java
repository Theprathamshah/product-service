package com.prathamcodes.product_service;

import com.prathamcodes.product_service.model.Product;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		ArrayList<Product> products = new ArrayList<>();

		Product product = new Product(1L, "Laptop", 999.99);
		products.add(product);

		System.out.println("Product Name: " + product.getName());
		System.out.println("Total Products: " + products.size());
	}

}
