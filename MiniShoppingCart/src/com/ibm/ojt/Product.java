package com.ibm.ojt;

public class Product {
	private int code;
	private String name;
	private double price;
	private String imageLocation;
	
	public Product(int code, String name, double price, String imageLocation) {
		
		this.code = code;
		this.name = name;
		this.price = price;
		this.imageLocation = imageLocation;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	
}
