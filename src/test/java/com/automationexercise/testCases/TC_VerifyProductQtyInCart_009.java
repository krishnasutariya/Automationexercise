package com.automationexercise.testCases;

import com.automationexercise.pageObjects.*;

import junit.framework.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_VerifyProductQtyInCart_009 extends BaseClass {

	@Test
    public void countProductQtyInCart() throws InterruptedException {
		
	 ProductPage product = new ProductPage(driver);
	 product.selectFirstProduct();
	 product.increaseProductQuantity("2");
	 product.addToCart();
	 product.continueShopping();
	 
	 CartPage cart = new CartPage(driver);
	 cart.clickViewCart();
 
	 List<String> quantities = cart.getProductQuantities();

	 for (String quantity : quantities) {
	     System.out.println("Quantity in View Cart: " + quantity);
	 }
       
    }

}
