package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Product;

public interface ProductDao extends MongoRepository<Product, String> {
	public default Product addProduct(Product product) {
		UUID id = UUID.randomUUID();
		return addProduct(id, product);
	}
	public Product addProduct(UUID id, Product product);
	public List<Product> getProducts();
	public Optional<Product> getProductById(UUID id);
	public int updateProduct(UUID id, Product product);
	public String deleteProduct(UUID id);
}
