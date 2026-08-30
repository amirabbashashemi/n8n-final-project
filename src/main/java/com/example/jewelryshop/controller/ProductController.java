package com.example.jewelryshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jewelryshop.model.Product;

import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final Map<String, Product> productMap = new HashMap<>();

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productMap.put(product.getId(), product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(new ArrayList<>(productMap.values()), HttpStatus.OK);
    }
}