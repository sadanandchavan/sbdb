package com.example.sbdb.service;

import java.util.List;
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

	public Product getProduct(int productId){
		Optional<Product> product= productRepository.findById(productId);
		return product.get();
	}
	
	public List<Product> getAllProduct(){
			return (List<Product>) productRepository.findAll();	
	}
	

}
