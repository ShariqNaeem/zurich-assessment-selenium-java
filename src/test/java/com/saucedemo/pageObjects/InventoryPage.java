package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InventoryPage {
    private WebDriver driver;
    By cartIcon = By.cssSelector("[data-test=\"shopping-cart-link\"]");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCartIcon() {
        return driver.findElement(cartIcon);
    }
}
