package com.qa.java.product.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.qa.java.product.bean.Product;
import com.qa.java.product.exceptions.FileNotFoundExceptionHandler;
import com.qa.java.product.exceptions.IOExceptionHandler;
import com.qa.java.product.repository.ProductRepo;

public class ProductServices {

	ProductRepo productRepo;

	public ProductServices() {

		try {
			this.productRepo = new ProductRepo();
		} catch (FileNotFoundExceptionHandler e) {
			System.out.println(e.getMessage());
		} catch (IOExceptionHandler e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Product> getProducts() {

		return this.productRepo.getProducts();
	}

	/*public void getProductInfo() {

		for(Product p : getProducts()) {
			System.out.println("ID : " + p.getID());
			System.out.println("Name : " + p.getName());
			System.out.println("Price : £" + p.getPrice());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Rating : " + p.getRating());
			System.out.println("Discount Percentage : " + p.getDiscountPercentage() + "%");
			System.out.println("Available : " + p.getIsAvailable());

		}
	}

	public String getCheapestProduct() {

		List<Product> products = getProducts();

		float small = products.get(0).getPrice();
		String item = products.get(0).getName();

		for (Product p : products) {

			if (p.getPrice() < small) {

				small = p.getPrice();

				item = p.getName();

			}

		}
		return item;
	}*/

	public void getProductInfo() {

		List<Product> products = getProducts();

		products.stream().forEach(prod -> System.out.println(prod));
	}

	public String getCheapestProduct() {
		List<Product> products = getProducts();

		Product cheapestProduct = products.stream().min(Comparator.comparingDouble(Product::getPrice)).get();

		return cheapestProduct.getName();
	}

	public String getDearestProduct() {

		List<Product> products = getProducts();

		Product dearestProduct = products.stream().max(Comparator.comparingDouble(Product::getPrice)).get();

		return dearestProduct.getName();
	}

	public String getHighestRating() {

		List<Product> products = getProducts();

		Product highestRating = products.stream().min(Comparator.comparing(Product::getRating)).get();

		return highestRating.getName();
	}

	public void getAvailableProducts(){

		List<Product> products = getProducts();

		List<Product> isAvailable = products.stream().filter(prod -> prod.getIsAvailable() == true).collect(Collectors.toList());

		System.out.println("Items Currently In Stock : ");

		isAvailable.stream().forEach(prod -> {System.out.println(prod);});
	}
}
