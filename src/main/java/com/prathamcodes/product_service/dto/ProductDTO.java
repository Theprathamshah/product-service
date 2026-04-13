package com.prathamcodes.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @Positive(message = "Price must be greater than zero")
    private double price;
}
