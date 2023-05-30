package com.automationexercise.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPage {

	WebDriver driver;

	public ViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* View Product Page */

	@FindBy(xpath = "//*[@class='product-information']")
	List<WebElement> viewProductInformation;

	public List<String> getProductInformation() {

		List<String> productInfo = new ArrayList<>();
		if (viewProductInformation.size() > 0) {

			for (WebElement productElement : viewProductInformation) {
				// Retrieve the product name, price, quantity, etc. from the view cart table
				String productName = productElement.findElement(By.xpath(".//h2")).getText();
				String productCategory = productElement.findElement(By.xpath(".//p")).getText();
				String productPrice = productElement.findElement(By.xpath(".//span/span[1]")).getText();
				String productQty = productElement.findElement(By.xpath(".//span/input[1]")).getText();
				productInfo.add(productPrice);
				productInfo.add(productCategory);
				productInfo.add(productPrice);
				productInfo.add(productQty);
				System.out.println("Product Name: " + productName);
				System.out.println("Product Price: " + productPrice);
			}
		}
		return productInfo;
	}
}
