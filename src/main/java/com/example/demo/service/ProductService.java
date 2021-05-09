package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

@Service
public class ProductService {
	
	private final ProductDao productDao;

	public ProductService(@Qualifier("fakeProductDao") ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public Product addProduct(Product product){
		return productDao.addProduct(product);
	}
	
	public List<Product> getProduct(){
		return productDao.getProducts();
	}
	
	public Optional<Product> getProductById(UUID id) {
		return productDao.getProductById(id);
	}
	public int updateProduct(UUID id, Product product) {
		return productDao.updateProduct(id, product);
	}
	
	public String deleteProduct(UUID id) {
		return productDao.deleteProduct(id);
	}
}
