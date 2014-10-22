package com.project;

/**
 * Offer defines the type of Offer on a Product
 * This identifies 3 different types of offer but currently implements only
 * BuyXgetYfree
 */
public class Offer {

	/**
	 * Discount Value is a place holder for discount or BuyXgetYfree based on the Offer Type:
	 * if offerType = BuyXgetYfree, discountValue holds 'Y'(get Y free)  OR the 
	 * 'Number of items ' that are free with the discount
	 */
	private int discountValue ; 
	/**
	 * Discount Threshold is a place holder for BuyXgetYfree based on the Offer Type:
	 * if offerType = BuyXgetYfree, discountThresholds holds 'X'(buy X) OR the threshold to be reached
	 * to get the discount
	 */	
	private int discountThreshold ; 
	private OfferType offerType ;
	
	// defines the offerTypes 
	public enum OfferType {

		BuyXgetYfree, PercentOff, DollarOff ;
	}	
	
	
	/**
	 * Constructor to create Offer object for buyXgetYfree.
	 * Different constructors for other types of offer can be created
	 * @param discountValue
	 * @param discountThreshold
	 * @param offerType
	 */
	public Offer(int discountValue, int discountThreshold, OfferType offerType) {
		this.discountValue = discountValue;
		this.discountThreshold = discountThreshold;
		this.offerType = offerType;
	}
	public int getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}
	public int getDiscountThreshold() {
		return discountThreshold;
	}
	public void setDiscountThreshold(int discountThreshold) {
		this.discountThreshold = discountThreshold;
	}
	public OfferType getOfferType() {
		return offerType;
	}
	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}
	
	
	
}
