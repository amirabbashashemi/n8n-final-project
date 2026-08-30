package com.example.jewelryshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final Map<String, Product> products = new ConcurrentHashMap<>();

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        products.put(product.getId(), product);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(new ArrayList<>(products.values()));
    }
}