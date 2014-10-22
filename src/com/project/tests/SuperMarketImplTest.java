package com.project.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.project.Offer;
import com.project.Product;
import com.project.Offer.OfferType;
import com.project.service.SuperMarket;
import com.project.service.SuperMarketImpl;

public class SuperMarketImplTest {


	@Test
	public void testCheckOut() {
			
		SuperMarket superMarket = new SuperMarketImpl() ;
        superMarket.addProduct(new Product("A",new BigDecimal(20)));
        
        Product productB = new Product("B",new BigDecimal(50));
        productB.setOffer(new Offer(2,5,OfferType.BuyXgetYfree));
        superMarket.addProduct(productB);
        
        superMarket.addProduct(new Product("C",new BigDecimal(30)));
        
		assertEquals("Pass", new BigDecimal(240), superMarket.checkOut("ABBACBBAB"));
	}
	@Test
	public void testCheckOut2() {
		
		SuperMarket superMarket = new SuperMarketImpl() ;
        superMarket.addProduct(new Product("A",new BigDecimal(20)));
        
        Product productB = new Product("B",new BigDecimal(50));
        productB.setOffer(new Offer(2,5,OfferType.BuyXgetYfree));
        superMarket.addProduct(productB);
        
        superMarket.addProduct(new Product("C",new BigDecimal(30)));
        
		assertEquals("Pass", new BigDecimal(340), superMarket.checkOut("ABBACBBABBB"));
	}

	@Test
	public void testCheckOut3() {
		
		SuperMarket superMarket = new SuperMarketImpl() ;
        superMarket.addProduct(new Product("A",new BigDecimal(20)));
        
        Product productB = new Product("B",new BigDecimal(50));
        productB.setOffer(new Offer(2,5,OfferType.BuyXgetYfree));
        superMarket.addProduct(productB);
        
        superMarket.addProduct(new Product("C",new BigDecimal(30)));
        
		assertEquals("Pass", new BigDecimal(290), superMarket.checkOut("ABBACBBA"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCheckOutforNull() {
	               
        SuperMarket superMarket = new SuperMarketImpl() ;
        superMarket.addProduct(new Product("A",new BigDecimal(20)));
        
        Product productB = new Product("B",new BigDecimal(50));
        productB.setOffer(new Offer(2,5,OfferType.BuyXgetYfree));
        superMarket.addProduct(productB);
        
        superMarket.addProduct(new Product("C",new BigDecimal(30)));
        
		superMarket.checkOut(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckOutforInvalidProduct() {
		
		SuperMarket superMarket = new SuperMarketImpl() ;
        superMarket.addProduct(new Product("A",new BigDecimal(20)));
        
        Product productB = new Product("B",new BigDecimal(50));
        productB.setOffer(new Offer(2,5,OfferType.BuyXgetYfree));
        superMarket.addProduct(productB);
        
        superMarket.addProduct(new Product("C",new BigDecimal(30)));
        
		superMarket.checkOut("ABBACBBAD");

	}
}
