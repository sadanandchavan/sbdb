package com.example.sbdb.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbdb.cache.ProductCache;
import com.example.sbdb.dto.Product;
import com.example.sbdb.service.ProductService;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private ProductService productService;
	@Autowired ProductCache productCache;
	
	@PostMapping("/add")
	public void addProduct(@RequestBody Product product) {
		System.out.println("request for prouct add.");
		productService.saveProduct(product);
	}
	
	@GetMapping("/get")
	public Product getProduct(@RequestParam String productId) {
		//return productService.getProduct(Integer.parseInt(productId));
		try {
			return productCache.getProduct(productId);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
