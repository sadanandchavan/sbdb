package com.example.sbdb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.sbdb.dto.Product;
import com.example.sbdb.service.ProductService;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	
	@Mock
	private ProductService productService;
	
	@Test
	void findById() {
		Product product = new Product();
		product.setProductId(5);
		product.setProductName("APPLe");
		product.setQuantity("10");
		
		int productId=5;
		
		given(productService.getProduct(productId)).wil
		
	}

}
