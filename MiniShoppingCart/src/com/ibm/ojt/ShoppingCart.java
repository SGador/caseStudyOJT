package com.ibm.ojt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
	private Map<Integer, ShoppingCartItem> shoppingCart;
	public ShoppingCart(){
		shoppingCart = new TreeMap<Integer, ShoppingCartItem>();
	}
	public Collection<ShoppingCartItem> getCartItems(){
		
		return new ArrayList<ShoppingCartItem>(shoppingCart.values());
	}
	public void addToCart(Product product){
		
		if(shoppingCart.get(product.getCode())==null){
			shoppingCart.put(product.getCode(),new ShoppingCartItem(product,1));
		}
		else{
			ShoppingCartItem newItem = shoppingCart.get(product.getCode());
			newItem.setQuantity(newItem.getQuantity()+1);
			shoppingCart.replace(product.getCode(), newItem);
		}
		
	}
	public void updateItemQuantity(Product product, int quantity){
		if(shoppingCart.get(product.getCode())==null){
			shoppingCart.put(product.getCode(),new ShoppingCartItem(product,1));
		}
		
			ShoppingCartItem newItem = shoppingCart.get(product.getCode());
			newItem.setQuantity(quantity);
			shoppingCart.replace(product.getCode(), newItem);
		
	}
	public void deleteItem(Product product){
		if(shoppingCart.get(product.getCode())!=null){
			shoppingCart.remove(product.getCode());
		}
	}
	public double getTotal(){
		double total=0;
		for(ShoppingCartItem sci : shoppingCart.values()){  
			 total+=(sci.getProduct().getPrice()*sci.getQuantity());
		}  
		return total;
	}
}	
