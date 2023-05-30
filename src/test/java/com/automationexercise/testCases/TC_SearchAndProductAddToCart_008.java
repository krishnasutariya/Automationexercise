package com.automationexercise.testCases;

import com.automationexercise.pageObjects.*;

import junit.framework.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class TC_SearchAndProductAddToCart_008 extends BaseClass {

	@Test
	public void productPageSearchProduct() throws InterruptedException {
		ProductPage product = new ProductPage(driver);
		product.clickproductPageLink();
		logger.info("User click on product page link");
		Thread.sleep(5000);
		logger.info("Product Page Heading before search product " + product.clickproductPageHeading());
		product.enterProductPageSearchText(productname);
		logger.info("Enter value into search box");
		product.clickproductPageSearchButton();
		logger.info("User click on search button");
		Thread.sleep(5000);
		logger.info("Product Page Heading After search product " + product.clickproductPageHeading());

	}

	@Test
	public void productPageVerifySearchProductName() throws InterruptedException {
		ProductPage product = new ProductPage(driver);
		productPageSearchProduct();

		// Get the list of product names
		List<String> productNames = product.getProductNames();

		// Use the product names in your assertions or further processing
		for (String productName : productNames) {
			System.out.println("Product Name: " + productName);

			// Add your assertions or other actions here
			if (productName.contains(productName)) {
				System.out.println("Search product is visible: " + productName);
			} else {
				System.out.println("Searching is not working: " + productName);
			}
		}
	}

	@Test
	public void clickAddToCart() throws InterruptedException {
		ProductPage product = new ProductPage(driver);
		productPageSearchProduct();
		product.getFirstProductClickAddtoCart();
		Thread.sleep(5000);
		product.clickContinueShoppingButton();
	}

	@Test
	public void viewCartProduct() throws InterruptedException {

		ProductPage product = new ProductPage(driver);
		product.clickViewCart();
		System.out.println("Clicked 'View Cart' button!");

		Thread.sleep(2000);

		product.getProductListViewCart();

	}

}
