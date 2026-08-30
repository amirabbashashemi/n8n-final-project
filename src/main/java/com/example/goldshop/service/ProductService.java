package com.example.goldshop.service;

import com.example.goldshop.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Service
public class ProductService {
    private Map<String, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }
}