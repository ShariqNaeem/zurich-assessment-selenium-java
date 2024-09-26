package com.saucedemo.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPageFactory {
    private WebDriver driver;
    @FindBy(css = "[data-test=\"shopping-cart-link\"]")
    private WebElement cartIcon;

    public InventoryPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }
}
