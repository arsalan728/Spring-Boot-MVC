package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "smartbazar")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Correctly used with @Id
    private long id;

    private String name;
    private String brand;
    private String madeIn;
    private double price;
    private int quantity;
    private double discountRate;
    private double taxRate;
    private double discountPrice;
    private double offerPrice;
    private double finalPrice;
    private double stockRate;
}
