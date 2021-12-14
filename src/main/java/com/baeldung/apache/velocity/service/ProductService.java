package com.baeldung.apache.velocity.service;

import com.baeldung.apache.velocity.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ProductService {

	Logger logger = Logger.getLogger(ProductService.class.getName());

	public List<Product> getProducts() {
        logger.info("Product service returning list of products");

		return Arrays.asList(new Product("Laptop", 31000.00), new Product("Mobile", 16000.00),
				new Product("Tablet", 15000.00), new Product("Camera", 23000.00));
	}
}
