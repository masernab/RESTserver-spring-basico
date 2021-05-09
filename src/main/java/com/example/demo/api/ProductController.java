package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/product")
@RestController
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public Product addProduct(@Validated @NonNull @RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping
	public List<Product> getProduct() {
		return productService.getProduct();
	}
	@GetMapping(path="{id}")
	public Product getProductById(@PathVariable("id") UUID id) {
		return productService.getProductById(id).orElse(null);
	}
	
	@PutMapping(path="{id}")
	public int updateProduct(@PathVariable("id") UUID id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping(path="{id}")
	public String deleteProduct(@PathVariable("id") UUID id) {
		return productService.deleteProduct(id);
	}
}
