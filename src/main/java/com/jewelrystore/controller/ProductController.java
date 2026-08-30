package com.jewelrystore.controller;

import com.jewelrystore.model.Product;
import com.jewelrystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        boolean isAdded = productService.addProduct(product);
        if (isAdded) {
            return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Product already exists.", HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}