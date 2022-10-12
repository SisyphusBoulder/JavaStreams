package com.qa.java.product.repository;

import java.util.List;

import com.qa.java.product.bean.Product;
import com.qa.java.product.exceptions.FileNotFoundExceptionHandler;
import com.qa.java.product.exceptions.IOExceptionHandler;
import com.qa.java.product.utils.ProductImporter;

public class ProductRepo {

	List<Product> productList;
	
	public ProductRepo() throws FileNotFoundExceptionHandler, IOExceptionHandler{
		ProductImporter productImporter = new ProductImporter();
		productList = productImporter.readProductCSVFile("C://Users/Chris/eclipse-workspace/streams/src/com/qa/java/product/ProductCSV.csv");
		if (productList == null) throw new FileNotFoundExceptionHandler("File could not be found! Please check the location!");
	}
	
	public List<Product> getProducts(){
		
		return this.productList;
	}
}
