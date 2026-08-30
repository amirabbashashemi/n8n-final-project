package com.example.jewelrystore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jewelrystore.model.Product;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private Map<String, Product> productMap = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        if (productMap.containsKey(product.getId())) {
            return new ResponseEntity<>("Product already exists.", HttpStatus.CONFLICT);
        }
        productMap.put(product.getId(), product);
        return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(new ArrayList<>(productMap.values()), HttpStatus.OK);
    }
}