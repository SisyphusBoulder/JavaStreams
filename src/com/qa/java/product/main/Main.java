package com.qa.java.product.main;

import com.qa.java.product.service.ProductServices;

public class Main {

	public static void main(String[] args) {

		ProductServices productServices = new ProductServices();
		
		productServices.getProductInfo();
		
		System.out.println("Cheapest Product : " + productServices.getCheapestProduct());
		
		System.out.println("Dearest Product : " + productServices.getDearestProduct());
		
		System.out.println("Highest Rated Product : " + productServices.getHighestRating());
		
		productServices.getAvailableProducts();

	}

}