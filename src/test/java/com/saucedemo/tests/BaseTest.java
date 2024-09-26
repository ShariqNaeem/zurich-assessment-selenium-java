package com.saucedemo.tests;

import com.saucedemo.pageFactory.CommonPageFactory;
import com.saucedemo.pageFactory.InventoryPageFactory;
import com.saucedemo.pageFactory.LoginPageFactory;
import com.saucedemo.pageObjects.CommonPage;
import com.saucedemo.pageObjects.InventoryPage;
import com.saucedemo.pageObjects.LoginPage;
import com.saucedemo.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    CommonPage commonPage;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    CommonPageFactory commonPageFactory;
    LoginPageFactory loginPageFactory;
    InventoryPageFactory inventoryPageFactory;

    @BeforeMethod
    public void driverInitiate() throws IOException {
        DriverManager.driverSetup();
        WebDriver driver = DriverManager.driver;
        commonPage = new CommonPage(driver);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

        commonPageFactory = new CommonPageFactory(driver);
        loginPageFactory = new LoginPageFactory(driver);
        inventoryPageFactory = new InventoryPageFactory(driver);
    }

    @AfterMethod
    public void driverClose(){
        DriverManager.closeBrowser();
    }
}
