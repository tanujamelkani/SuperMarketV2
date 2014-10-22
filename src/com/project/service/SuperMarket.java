package com.project.service;

import java.math.BigDecimal;

import com.project.Product;

/**
 * Interface for the SuperMarket
 */
public interface SuperMarket {

	/**
	 * Adds the products that are sold in the SuperMarket.
	 * @param product
	 */
	public void addProduct(Product product); 
	
	
	/**
	 * Takes the shopping cart items as as string and calculates the total invoice
	 * after the discounts are applied from the offers on the products in the cart
	 * @param checkedOutItems
	 * @return Total Invoice Amount
	 */
	public BigDecimal checkOut(String checkedOutItems); 
}
