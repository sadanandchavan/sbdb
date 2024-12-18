package com.example.sbdb.cache;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sbdb.dto.Product;
import com.example.sbdb.service.ProductService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import jakarta.annotation.PostConstruct;

@Component
public class ProductCache {

	LoadingCache<String, Map<String, String>> loadingCache;
	@Autowired
	private ProductService productService;

	LoadingCache<String, Product> cache;

	@PostConstruct
	public void initialize() {
		System.out.println("initialize...");
		CacheLoader<String, Product> loader;
		loader = new CacheLoader<String, Product>() {
			@Override
			public Product load(String key) {
				System.out.println("load called..."+key);
				return 	productService.getProduct(Integer.parseInt(key));
			}
		};
		System.out.println("cache start...");
		cache = CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.MINUTES).expireAfterWrite(15, TimeUnit.MINUTES)
				.build(loader);
		
		System.out.println("Print cache:"+cache.size());

	}

	public Product  getProduct(String key) throws ExecutionException {
		System.out.println("Get product called for "+key);
		Product val = cache.get(key);
		System.out.println("Print cache:"+cache.size());
		return val;

	}

	/*
	 * @PostConstruct
	public void init() {
		CacheLoader<String, String> loader;
		HashMap<String, String> map = new HashMap<String, String>();
		loader = new CacheLoader<String, String>(){
			@Override
			public String load(String key) throws Exception {

				List<Product> productList= 	productService.getAllProduct();
				productList.stream().forEach(entry->{
					map.put(entry.getProductName(), entry.getQuantity());
				});
				return map;
			}
		};


	}
	 */
}
