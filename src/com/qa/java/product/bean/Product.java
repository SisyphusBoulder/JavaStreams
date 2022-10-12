package com.qa.java.product.bean;

import java.io.Serializable;

public class Product implements Serializable{

	private int id;
	private String name;
	private float price;
	private String category;
	private char rating;
	private float discountPercentage;
	private boolean isAvailable;


	public Product(){}

	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return this.price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public char getRating() {
		return this.rating;
	}
	public void setRating(char rating) {
		this.rating = rating;
	}
	public float getDiscountPercentage() {
		return this.discountPercentage;
	}
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price =" + price + ", category = " + category + ", rating = " + rating + ", discount = " + discountPercentage + ", Available = " + isAvailable +"]";
	}
}