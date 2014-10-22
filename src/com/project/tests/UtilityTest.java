package com.project.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.project.Offer;
import com.project.Product;
import com.project.Offer.OfferType;
import com.project.Utility;

public class UtilityTest {

	@Test
	public void testCalculateDiscountWithOffer() {
		
		BigDecimal testPriceB = new BigDecimal(50);
        Product testProductB = new Product("B", testPriceB );        
		Offer offer = new Offer(2,5, OfferType.BuyXgetYfree);	
		testProductB.setOffer(offer);
		
		assertEquals("Pass", new BigDecimal(100), Utility.calculateDiscount(testProductB, 5));
	}

	@Test
	public void testCalculateDiscountWithOfferQuantityBelowLimit() {
		
		BigDecimal testPriceB = new BigDecimal(50);
        Product testProductB = new Product("B", testPriceB );        
		Offer offer = new Offer(2,5, OfferType.BuyXgetYfree);	
		testProductB.setOffer(offer);
		
		assertEquals("Pass", new BigDecimal(0), Utility.calculateDiscount(testProductB, 4));
	}
	
	
	@Test
	public void testCalculateDiscountWithOfferDoubleQuantity() {
		
		BigDecimal testPriceB = new BigDecimal(50);
        Product testProductB = new Product("B", testPriceB );        
		Offer offer = new Offer(2,5, OfferType.BuyXgetYfree);	
		testProductB.setOffer(offer);
		
		assertEquals("Pass", new BigDecimal(200), Utility.calculateDiscount(testProductB, 10));
	}
	@Test
	public void testCalculateDiscountNoOffer() {
		
		BigDecimal testPriceA = new BigDecimal(20);
        Product testProductA = new Product("A", testPriceA );        
		
		assertEquals("Pass", new BigDecimal(0), Utility.calculateDiscount(testProductA, 2 ));
	}
}
