package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products")
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public Product addProduct(@RequestBody ProductDTO dto) {

	    Product product = modelMapper.map(dto, Product.class);

	    return productService.saveProduct(product);
	}

	@GetMapping
	public Page<Product> getAllProducts(
	        @RequestParam int page,
	        @RequestParam int size,
	        @RequestParam String sortBy) {

	    return productService.getAllProducts(page, size, sortBy);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
	    return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
	    productService.deleteProduct(id);
	    return "Deleted successfully";
	}
	
	@GetMapping("/search/{keyword}")
	public List<Product> searchProducts(@PathVariable String keyword) {

	    return productService.searchProducts(keyword);

	}
}
