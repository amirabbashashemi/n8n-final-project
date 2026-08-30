package com.example.jewelryshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private Map<Integer, Product> productMap = new HashMap<>();
    private int idCounter = 1;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        product.setId(idCounter++);
        productMap.put(product.getId(), product);
        return ResponseEntity.ok("Product added successfully: " + product.getId());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(new ArrayList<>(productMap.values()));
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}