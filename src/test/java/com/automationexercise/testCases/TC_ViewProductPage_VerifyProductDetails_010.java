package com.automationexercise.testCases;

import com.automationexercise.pageObjects.*;
import java.util.List;
import org.testng.annotations.Test;

public class TC_ViewProductPage_VerifyProductDetails_010 extends BaseClass {

    @Test
    public void productDetail() throws InterruptedException {

        // Create instances of the Page Objects
        ProductPage product = new ProductPage(driver);
        ViewPage view = new ViewPage(driver);
        // Get the product details from the ProductPage
        List<String> productDetails = product.selectFirstProduct();

        // Check if the productDetails list is not empty before accessing its elements
        if (!productDetails.isEmpty()) {
            String expectedPrice = productDetails.get(0);
            String expectedName = productDetails.get(1);

            // Get the product information from the ViewPage
            List<String> productInfo = view.getProductInformation();
            String actualPrice = productInfo.get(0);
            String actualName = productInfo.get(1);
            if (actualPrice.trim().equals(expectedPrice.trim()) && actualName.trim().equals(expectedName.trim())) {
                System.out.println("Product price and name match.");
            } else {
                System.out.println("Product price or name doesn't match.");
            }
        } else {
            System.out.println("Product information not found on the ViewPage.");
        }
    }
}
