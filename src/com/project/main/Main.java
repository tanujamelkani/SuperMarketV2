
package com.project.main;

import java.math.BigDecimal;

import com.project.Offer;
import com.project.Offer.OfferType;
import com.project.Product;
import com.project.service.SuperMarket;
import com.project.service.SuperMarketImpl;


/**
 * This is a example of the SuperMarket Project with one offer and products A B & C.
 * Entry of data is HardCoded as a string 
 * In real world example the input should be from POS system in 
 * form of list of objects or some other format
 * Product and offer initialization could be read from a database or file.
 * 
 */
public class Main {

    
    public static void main(String[] args) {
                      
        // Product A - Without offer
        BigDecimal priceA = new BigDecimal(20);
        Product productA = new Product("A",priceA);
        
        
        // Product B - With Offer buy XgetYfree (In our example we have buy 5 and get 2 free)
        BigDecimal priceB = new BigDecimal(50);
        Offer offerB = new Offer(2,5,OfferType.BuyXgetYfree); 
        Product productB = new Product("B",priceB);
        productB.setOffer(offerB);
        
        // Product C - Without offer
        BigDecimal priceC = new BigDecimal(30);
        Product productC = new Product("C",priceC);
        
        // Create a SuperMarket object and Add the products that are sold there
        SuperMarket superMarket = new SuperMarketImpl() ;
        superMarket.addProduct(productA);
        superMarket.addProduct(productB);
        superMarket.addProduct(productC);

        // Call the checkout Method of SuperMarket Object. 
        // A hardcoded string is passed
        
        try
        {
        	BigDecimal total = superMarket.checkOut("ABBACBBABD");
        	System.out.println(total);
        }
        catch(IllegalArgumentException exception)
        {
        	String exceptionMsg = exception.getMessage();
        	System.out.println(exceptionMsg);
        }
        

    }
    
}