package com.saucedemo.pageFactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonPageFactory {
    private WebDriver driver;

    public CommonPageFactory(WebDriver driver){
        this.driver = driver;
    }
    public void validateURL(String expectedUrl){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }
}
