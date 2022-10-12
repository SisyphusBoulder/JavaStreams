package com.qa.java.product.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qa.java.product.bean.Product;

public class ProductImporter {


	public List<Product> readProductCSVFile(String filepath) {

		List<Product> products = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
			System.out.println(br.readLine()); //read header of csv file
			String productData = br.readLine();
			while (productData != null) {
				System.out.println(productData);
				String[] productDataSplit = productData.split(", ");
				Product product = new Product();
				product.setID(Integer.parseInt(productDataSplit[0]));
				product.setName(productDataSplit[1]);
				product.setPrice(Float.parseFloat(productDataSplit[2]));
				product.setCategory(productDataSplit[3]);
				product.setRating(productDataSplit[4].charAt(0));
				product.setDiscountPercentage(Float.parseFloat(productDataSplit[5]));
				product.setIsAvailable(Boolean.parseBoolean(productDataSplit[6]));
				products.add(product);
				productData = br.readLine();

			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found! Please check the filename and location!");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("IO Exception! Please check the code and the file!");
			e.printStackTrace();
		}

		return products;
	}
}
