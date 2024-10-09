package com.example.sbdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sbdb.dto.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
