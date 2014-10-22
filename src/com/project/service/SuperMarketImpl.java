package com.project.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.project.Product;
import com.project.Utility;


/**
 * Represents the Supermarket system
 * A list of products that are sold at the SuperMarket are created here
 * Also includes the POS checkout implementation
 * Excludes the Inventory Management
 * Implementation of the SuperMarket interface
 */
public class SuperMarketImpl implements SuperMarket{
	
	
	/**
	 * A Map of products for sale at the SuperMarket
	 */
	private final Map<String,Product> productMap;
	
	
	/**
	 * Constructor for the SuperMarketImpl
	 */
	public SuperMarketImpl(){
		this.productMap = new HashMap<String, Product>(); 
	}
	
	
	/* (non-Javadoc)
	 * @see com.project.service.SuperMarket#addProduct(com.project.Product)
	 * Adds products to the SuperMarket
	 */
	public void addProduct(Product product) {

		productMap.put(product.getProductCode(), product);
		
	}

	/* (non-Javadoc)
	 * @see com.project.service.SuperMarket#checkOut(java.lang.String)
	 * Takes the shopping cart items as as string and calculates the total invoice
	 * after the discounts are applied from the offers on the products in the cart
	 * @param checkedOutItems
	 * @return Total Invoice Amount
	 */
	
	public BigDecimal checkOut(String checkedOutItems) {
		
		// Validation check for Null
		if(checkedOutItems == null)
			throw new IllegalArgumentException("Input List cannot be null");
		
		// Map of product and quantity of each in the shopping cart
		Map<Product,Integer> checkedOutItemsMap = new HashMap<Product, Integer>();
		
		// Iterate over the list of items in the input string to get each product
        for(char productCode : checkedOutItems.toCharArray()){
        	String  prodCode = String.valueOf(productCode) ;
        	
        	// Verify if the input product is a valid product at the SuperMarket If not Throw exception
        	if(productMap.containsKey(prodCode)){
        		int quantity = 0;
        		
        		// get the new quantity of the product in the shopping cart during this step in the iteration
        		quantity = checkedOutItemsMap.get(productMap.get(prodCode))==null?1:checkedOutItemsMap.get(productMap.get(prodCode))+1;
        		
        		// Add the product or update the quantity in the checkedOutItemsMap
                checkedOutItemsMap.put(productMap.get(prodCode),quantity );
            }
        	else
        	{
        		throw new IllegalArgumentException("Invalid Product Code");
        	}
        }
        
        // Return the Total Invoice Amount
        return calculateTotal(checkedOutItemsMap);

	}

	/**
	 * Calculates the total InvoiceAmount for a list of products and the quantity of each product
	 * @param checkedOutItemsMap - A map of Products and corresponding quantity of each in the shopping cart
	 * @return Returns the Total Invoice Amount
	 */
	private BigDecimal calculateTotal(Map<Product,Integer> checkedOutItemsMap){
		
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		// Iterate through each product in the Shopping cart
		for(Product product : checkedOutItemsMap.keySet()){
			
			// Compute the total Price (without discount) for each product
			totalPrice = totalPrice.add((product.getPrice()).multiply(new BigDecimal(checkedOutItemsMap.get(product))));
			
			//Subtract the discount for each product based on the offer on it and the quantity in the shopping cart
			totalPrice = totalPrice.subtract(Utility.calculateDiscount(product, checkedOutItemsMap.get(product)));
			
		}
  	  
		// Return the Total Price
  	  return totalPrice;
    }
	
	

	
	
}
