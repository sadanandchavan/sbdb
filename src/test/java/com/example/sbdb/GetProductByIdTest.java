package com.example.sbdb;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.sbdb.dto.Product;
import com.example.sbdb.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
public class GetProductByIdTest {
	
	
	@Mock
	private ProductService productService;

	@Autowired
    private MockMvc mockMvc;
	
	/*
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
	*/
	
	
    @Test
    public void getProductById() throws Exception {
      
    
    	this.mockMvc.perform(get("http://localhost:8080/get?productId=100"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"productName\":\"Apple\",\"productId\":100,\"quantity\":\"10\"}")));
             
    	
        
       // ResultActions ra = this.mockMvc.perform(requestBuilder);
        //assertEquals("{\"productName\":\"Apple\",\"productId\":100,\"quantity\":\"10\"}", ra.andExpect(content().string("{\"productName\":\"Apple\",\"productId\":100,\"quantity\":\"10\"}")));
    }

}