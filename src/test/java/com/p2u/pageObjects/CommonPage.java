package com.p2u.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class CommonPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonPage(WebDriver driver){
        this.driver = driver;
        this.getWait();
    }
    public void validateURL(String expectedUrl){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }

    private void getWait(int... seconds) {
        int timeout = seconds.length > 0 ? seconds[0] : 20;
        this. wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void waitForElementVisibility(WebElement element, int... seconds) {
        this.getWait();
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
