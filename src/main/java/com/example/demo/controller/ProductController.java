package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final Map<Long, String> productMap = new HashMap<>();
    private long currentId = 1;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody String product) {
        if (productMap.containsValue(product)) {
            return new ResponseEntity<>("Product already exists!", HttpStatus.CONFLICT);
        }
        productMap.put(currentId++, product);
        return new ResponseEntity<>("Product added successfully!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllProducts() {
        return new ResponseEntity<>(new ArrayList<>(productMap.values()), HttpStatus.OK);
    }
}