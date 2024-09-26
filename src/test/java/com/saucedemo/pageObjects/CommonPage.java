package com.saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CommonPage {
    private WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
    }
    public void validateURL(String expectedUrl){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }
}
