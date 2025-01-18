package com.p2u.utils;

import com.p2u.testData.ConstantTestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class DriverManager {
    public static WebDriver driver;

    public static void driverSetup() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().window().maximize();

        driver.get(ConstantTestData.baseURL);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(
                ConstantTestData.title.contains(actualTitle),
                "Page title does not contain the expected text. Actual: " + actualTitle + ", Expected: " + ConstantTestData.title
        );
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
