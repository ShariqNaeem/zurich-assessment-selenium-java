package com.p2u.tests;

import com.p2u.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver; // Make WebDriver accessible to all test methods in child classes


    @BeforeMethod
    public void driverInitiate() throws IOException {
        DriverManager.driverSetup();
        driver = DriverManager.driver;
    }

    @AfterMethod
    public void driverClose(){
        DriverManager.closeBrowser();
    }
}
