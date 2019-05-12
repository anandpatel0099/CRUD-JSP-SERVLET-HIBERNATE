package com.marlabs.dao;

import java.util.List;

import com.marlabs.domain.Product;

public interface ProductDao {
	Long saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Long id);

	Product findProductById(Long id);

	List<Product> findAllProducts();
}
