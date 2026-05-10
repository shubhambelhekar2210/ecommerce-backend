package com.example.demo.service;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ProductService {
	
	Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
    
    Page<Product> getAllProducts(int page, int size, String sortBy);
    
    List<Product> searchProducts(String name);
}