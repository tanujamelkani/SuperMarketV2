package com.project;

import java.math.BigDecimal;

/*
 * Utility class with functions to calculate the discount for Product
 * All the discount calculations should be implemented here. Only one discount type is implemented BuyXgetYfree
 */
public class Utility {

	
	/**
	 * Defines the forumula used for the calculating the discount of BuyXgetYFree offer
	 * Other such forumula's needs to be implemented for other offers
	 * @param quantity
	 * @param threshold
	 * @param discountValue
	 * @return
	 */
	private static int formulaBuyXgetYFree(int quantity, int threshold,int discountValue){
	 int result = quantity/threshold;
	 return result*discountValue ;
	}
	


	/**Calculates the discount for any product based on its quantity and the current Offer
	 * 
	 * Only implements one type of Offer (BuyXgetYFree). Other offers can be implemented here in the if..Else
	 * @param product
	 * @param quantity
	 * @return
	 */
	public static BigDecimal calculateDiscount(Product product, int quantity){
		
		BigDecimal discount =  BigDecimal.ZERO;
		
		if (product.getOffer() != null){
			if (product.getOffer().getOfferType().equals(Offer.OfferType.BuyXgetYfree)){
				int threshold = product.getOffer().getDiscountThreshold();
				int discountValue = product.getOffer().getDiscountValue();
				discount = product.getPrice().multiply(new BigDecimal(Utility.formulaBuyXgetYFree(quantity,threshold,discountValue)));
				
			}
		}
		
		//Returns the Discount Amount
		return discount;
		
		
	}
	
}
