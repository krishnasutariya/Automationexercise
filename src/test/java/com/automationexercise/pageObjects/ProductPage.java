package com.automationexercise.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/products']")
	WebElement productPageLink;

	@FindBy(xpath = "//*[@id='search_product']")
	WebElement productPageSearchProductText;

	@FindBy(xpath = "//*[@id='submit_search']")
	WebElement productPageSearchProductButton;

	@FindBy(xpath = "//div[@class='features_items']/h2")
	WebElement productPageHeading;

	@FindBy(xpath = "//div[@class='productinfo text-center']/p")
	List<WebElement> productList;

	@FindBy(xpath = "//*[@id='submit_search']")
	WebElement productPageProductSearchButton;

	@FindBy(xpath = "//div[@class='productinfo text-center']/h2")
	WebElement productPrice;

	@FindBy(xpath = "//div[@class='productinfo text-center']")
	List<WebElement> products;

	@FindBy(xpath = "//*[@class='modal-footer']/button")
	WebElement continueShoppingButton;

	@FindBy(xpath = "//a[@href='/view_cart']")
	WebElement viewCartButton;

	@FindBy(xpath = "//*[@id='cart_info_table']/tbody/tr")
	List<WebElement> viewCartProductElements;

	/* Product Page - Product Details */
	@FindBy(xpath = "//div[@class='product-image-wrapper']")
	List<WebElement> productElements;

	@FindBy(xpath = "//div[2]/ul/li/a")
	WebElement viewProductButton;

	@FindBy(xpath = "//*[@id='quantity']")
	WebElement quantityInput;

	@FindBy(xpath = "//div[@class='product-information']/span/button")
	WebElement addToCartButton;

	@FindBy(xpath = "//div[@class='productinfo text-center']/h2")
	WebElement productPageProductPrice;

	@FindBy(xpath = "//div[@class='productinfo text-center']/p")
	WebElement productPageProductTitle;


	public void clickproductPageLink() {
		productPageLink.click();
	}

	public String clickproductPageHeading() {
		String heading = productPageHeading.getText();
		return heading;
	}

	public void enterProductPageSearchText(String productname) {
		productPageSearchProductText.sendKeys(productname);
	}

	public void clickproductPageSearchButton() {
		productPageProductSearchButton.click();
	}

	// Method to get the list of product names
	public List<String> getProductNames() {
		List<String> productNames = new ArrayList<>();

		for (WebElement product : productList) {
			productNames.add(product.getText());
		}
		return productNames;
	}

	public String getFirstProductClickAddtoCart() {
		WebElement firstProductElement = null;
		String firstProductName = null;
		int productElements = products.size();
		if (productElements > 0) {
			firstProductElement = products.get(0);
			firstProductName = firstProductElement.findElement(By.xpath(".//p")).getText();
			WebElement addToCartButton = firstProductElement.findElement(By.xpath(".//a"));
			addToCartButton.click();
		}
		return firstProductName;
	}

	public void clickContinueShoppingButton() {
		continueShoppingButton.click();
	}

	public void getProductDetails() {
		continueShoppingButton.click();
	}

	public List<String> getProductListViewCart() {
		List<String> productList = new ArrayList<>();

		if (viewCartProductElements.size() > 0) {

			for (WebElement productElement : viewCartProductElements) {
				// Retrieve the product name, price, quantity, etc. from the view cart table
				String productName = productElement.findElement(By.xpath(".//td[2]/h4")).getText();
				String productPrice = productElement.findElement(By.xpath(".//td[3]/p")).getText();
				productList.add(productPrice);
				productList.add(productName);
				System.out.println("Product Name: " + productName);
				System.out.println("Product Price: " + productPrice);
			}
		}
		return productList;
	}

	public List<String> selectFirstProduct() throws InterruptedException {
		List<String> productDetails = new ArrayList<>();
		if (productElements.size() > 0) {
			WebElement firstProductElement = productElements.get(0);
			String priceElement = firstProductElement.findElement(By.xpath(".//div/div[1]/h2")).getText();
            String nameElement = firstProductElement.findElement(By.xpath(".//div/div[1]/p")).getText();
            productDetails.add(priceElement);
            productDetails.add(nameElement);
            System.out.println("First Product Price: " + priceElement);
            System.out.println("First Product Name: " + nameElement);
			Thread.sleep(2000);
			viewProductButton.click();
			Thread.sleep(2000);
			System.out.println("View Product Page is open");
			Thread.sleep(2000);
		} else {
			System.out.println("No products found on the page.");
		}
		return productDetails;

	}

	public void increaseProductQuantity(String quantity) throws InterruptedException {
		quantityInput.clear();
		Thread.sleep(2000);
		quantityInput.sendKeys(quantity);
		System.out.println("Increased the product quantity to " + quantity);
	}

	public void addToCart() throws InterruptedException {
		addToCartButton.click();
		System.out.println("Clicked 'Add to Cart' button!");
		Thread.sleep(2000);
	}

	public void continueShopping() throws InterruptedException {
		continueShoppingButton.click();
		System.out.println("Clicked 'Continue Shopping' button!");
		Thread.sleep(2000);
	}

	public void clickViewCart() throws InterruptedException {
		viewCartButton.click();
		System.out.println("Clicked 'View Cart' button!");
		Thread.sleep(2000);
	}

}
