package com.p2u.tests;

import com.p2u.pageObjects.CommonPage;
import com.p2u.pageObjects.HomePage;
import com.p2u.pageObjects.LoginPage;
import com.p2u.testData.ConstantTestData;
import com.p2u.testData.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    CommonPage commonPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setupPages() {
        commonPage = new CommonPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    public void loginSuccess(){
        commonPage.waitForElementVisibility(homePage.getLoginBtn());
        homePage.getLoginBtn().click();
        commonPage.validateURL(ConstantTestData.loginURL);

        loginPage.loginUser(LoginTestData.valid_USERNAME, LoginTestData.valid_PASSWORD);

        commonPage.waitForElementVisibility(homePage.getLogoutBtn());
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed(), "Logout BTN is not displayed...");
    }
}
