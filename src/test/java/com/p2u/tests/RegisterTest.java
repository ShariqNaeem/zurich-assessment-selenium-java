package com.p2u.tests;

import com.p2u.pageObjects.CommonPage;
import com.p2u.pageObjects.HomePage;
import com.p2u.pageObjects.LoginPage;
import com.p2u.pageObjects.RegisterPage;
import com.p2u.testData.ConstantTestData;
import com.p2u.testData.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    CommonPage commonPage;
    LoginPage loginPage;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod
    public void setupPages() {
        commonPage = new CommonPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }
    @Test
    public void userRegistrationSuccess() throws InterruptedException {
        commonPage.waitForElementVisibility(homePage.getLoginBtn());
        homePage.getLoginBtn().click();
        commonPage.validateURL(ConstantTestData.loginURL);

        commonPage.waitForElementVisibility(loginPage.getRegisterBtn());
        loginPage.getRegisterBtn().click();
        commonPage.validateURL(ConstantTestData.registerURL);

        commonPage.waitForElementVisibility(registerPage.getAllAgreeBtn());
        registerPage.getAllAgreeBtn().click();
        commonPage.waitForElementVisibility(registerPage.getAgreeToTermsAndConditionsField());
        registerPage.getAgreeToTermsAndConditionsField().click();
        commonPage.validateURL(ConstantTestData.registerFormURL);

        registerPage.fillRegistrationFormWithRandomData();
    }
}
