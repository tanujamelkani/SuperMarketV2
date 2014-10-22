package com.project.tests;

import static org.junit.Assert.*;

import com.project.Offer;

import org.junit.Test;

import com.project.Offer.OfferType;

public class OfferTest {

	@Test
	public void testGetDiscountValue() {
		Offer offer = new Offer(2,5, OfferType.BuyXgetYfree);
		assertEquals("Pass", 2, offer.getDiscountValue());
	}

	@Test
	public void testGetDiscountThreshold() {
		
		Offer offer = new Offer(2,5, OfferType.BuyXgetYfree);
		assertEquals("Pass", 5, offer.getDiscountThreshold());		
		
	}

	@Test
	public void testGetOfferType() {
				
		Offer offer = new Offer(2,5, OfferType.BuyXgetYfree);
		assertEquals("Pass", OfferType.BuyXgetYfree, offer.getOfferType());		
	}

}
