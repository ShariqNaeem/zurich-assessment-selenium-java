package com.p2u.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductListingPage {
    private WebDriver driver;
    By productItems = By.cssSelector("div.product-box div.goods-img a");

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickRandomProductAndVerifyUrl() {
        // Locate all elements matching the locator
        List<WebElement> productLinks = driver.findElements(productItems);

        // Validate the list is not empty
        if (productLinks.isEmpty()) {
            throw new AssertionError("No product links found for the given locator.");
        }

        // Select a random element from the list
        Random random = new Random();
        WebElement randomProduct = productLinks.get(random.nextInt(productLinks.size()));

        // Get the href value
        String expectedUrl = randomProduct.getAttribute("href");

        // Click the element
        randomProduct.click();

        // Wait for the page to load (Optional: Add an explicit wait if necessary)
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));

        // Get the current URL and assert it matches the href
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The clicked product URL does not match the actual URL.");
    }

}
