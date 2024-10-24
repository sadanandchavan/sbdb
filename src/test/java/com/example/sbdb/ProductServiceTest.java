package com.example.sbdb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sbdb.dto.Product;
import com.example.sbdb.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
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
		
		when(productService.getProduct(productId)).thenReturn(product);
		
		assertEquals(5, productService.getProduct(productId).getProductId());
		
		
	}

}
