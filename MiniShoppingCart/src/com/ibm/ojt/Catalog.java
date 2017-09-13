package com.ibm.ojt;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
	private List<Product> products;
	public Catalog(){
		
	}
	public List<Product> getAllProducts(){
		//int code, String name, double price, String imageLocation
		products = new ArrayList<Product>();
		products.add(new Product(1,"iPhone",1200,"http://localhost:8080/MiniShoppingCart/resources/iphone.jpg"));
		products.add(new Product(2,"Galaxy S4",1000,"http://localhost:8080/MiniShoppingCart/resources/Galaxy_S4.jpg"));
		products.add(new Product(3,"Sony Xperia Z",800,"http://localhost:8080/MiniShoppingCart/resources/Sony-Xperia-Z-1.jpg"));
		products.add(new Product(4,"HTC One X",900,"http://localhost:8080/MiniShoppingCart/resources/htconex.png"));
		products.add(new Product(5,"Nokia Lumia",750,"http://localhost:8080/MiniShoppingCart/resources/nokia-lumia-920-yellow-and-red-nok-l920.jpg"));
		products.add(new Product(6,"iPad",700,"http://localhost:8080/MiniShoppingCart/resources/iPad.jpg"));
		products.add(new Product(7,"Nexus 7",500,"http://localhost:8080/MiniShoppingCart/resources/nexus7.jpg"));
		return products;
	}
	public Product getProduct(int code){
		if(products==null){
			getAllProducts();
			
		}
		
		for(Product x:products){
			if(x.getCode()==code){
				return x;
			}
			
		}
		return null;
		
	}
}
