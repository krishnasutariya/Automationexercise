package com.automationexercise.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* View Cart Page */

	@FindBy(xpath = "//*[@id='cart_info_table']/tbody/tr/td[4]")
	List<WebElement> productQuantities;

	@FindBy(xpath = "//a[@href='/view_cart']")
	WebElement viewCartButton;

	public void clickViewCart() throws InterruptedException {
		viewCartButton.click();
		System.out.println("Clicked 'View Cart' button!");
		Thread.sleep(2000);
	}

	public List<String> getProductQuantities() {
		List<String> quantities = new ArrayList<>();

		for (WebElement productQuantity : productQuantities) {
			quantities.add(productQuantity.getText());
		}
		return quantities;

	}
}
