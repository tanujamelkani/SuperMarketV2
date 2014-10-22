package com.project.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import com.project.Offer;
import com.project.Product;

import org.junit.Test;

import com.project.Offer.OfferType;

public class ProductTest {

	@Test
	public void testGetProductCode() {
		
		BigDecimal testPriceA = new BigDecimal(20);
        Product testProductA = new Product("A", testPriceA );
    		
		assertEquals("Pass", "A", testProductA.getProductCode());
	}

	@Test
	public void testGetPrice() {
		BigDecimal testPriceA = new BigDecimal(20);
        Product testProductA = new Product("A", testPriceA );
        
        assertEquals("Pass", testPriceA, testProductA.getPrice());
	}

	@Test
	public void testGetOffer() {
		
		BigDecimal testPriceA = new BigDecimal(20);
        Product testProductA = new Product("A", testPriceA );        
		Offer offer = new Offer(2,5, OfferType.BuyXgetYfree);	
		testProductA.setOffer(offer);
		
		assertEquals("Pass", OfferType.BuyXgetYfree, offer.getOfferType());
	}

}
