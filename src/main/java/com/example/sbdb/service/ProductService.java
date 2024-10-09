package com.example.sbdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbdb.dto.Product;
import com.example.sbdb.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public Optional<Product> getProduct(int productId){
		return productRepository.findById(productId);
	}
	

}
