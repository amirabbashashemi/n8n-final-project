package com.jewelrystore.service;

import com.jewelrystore.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final Map<String, Product> productMap = new HashMap<>();

    public boolean addProduct(Product product) {
        if (productMap.containsKey(product.getName())) {
            return false; // Duplicate product
        }
        productMap.put(product.getName(), product);
        return true;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
}