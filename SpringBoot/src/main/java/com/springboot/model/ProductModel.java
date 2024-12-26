package com.springboot.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	@NotBlank(message="product name cannot blank")
private String name;
	@NotBlank(message="brand cannot be blank")
private String brand;
	@NotBlank(message="madein field cannot be blank")
	private String madeIn;
	@Positive(message="price must greater than zero")
private double price;
	@Min(value=1,message="quantity must be atleast 1")
private int quantity;
	@DecimalMax(value="100.00",message=" field cannot be blank")
private double discountRate;
}
