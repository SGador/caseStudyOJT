package com.ibm.ojt;

public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private String creditCardNumber;
	private ShoppingCart shoppingCart;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public Customer(){
		
	}
	public Customer(String name, String address, String phoneNumber, String creditCardNumber, ShoppingCart shoppingCart){
		this.name=name;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.creditCardNumber=creditCardNumber;
		this.shoppingCart=shoppingCart;
	}
}
