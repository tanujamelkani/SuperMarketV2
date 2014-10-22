package com.project;

import java.math.BigDecimal;
/**
 * 	Product class defines a product available in a SuperMarket.
	A product object will have an Offer object as its member.
 */
public class Product {

	/**The product code of a product, this uniquely identifies a product**/
	private String productCode;
	
	/**The original price of a product**/
	private BigDecimal price;
	
	/**The current offer on a product**/
	private Offer offer;

	
	/**
	 * Constructs a new Product using the specified data
	 * @param productCode
	 * @param price
	 */
	public Product(String productCode, BigDecimal price) {
		super();
		this.productCode = productCode;
		this.price = price;
	}

	/**
	 * @returns the product code of this Product
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Sets the product code of the Product
	 * @param productCode
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @returns the Price of this Product
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * @param offer
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public boolean equals(Product product) {

		if (product == null)
			return false;
		if (!(product instanceof Product))
			return false;

		return this.productCode == product.getProductCode();

	}
	
	public int hashCode(){
		
		return this.productCode.hashCode();
	}

}