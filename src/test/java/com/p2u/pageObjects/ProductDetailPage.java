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

public class ProductDetailPage {
    private WebDriver driver;
    By buyNowBtn = By.id("sit_btn_buy");
    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getBuyNowBtn() {
        return driver.findElement(buyNowBtn);
    }

}
