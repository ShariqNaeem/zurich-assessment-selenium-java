package com.p2u.tests;

import com.p2u.pageObjects.*;
import com.p2u.testData.ConstantTestData;
import com.p2u.testData.LoginTestData;
import com.p2u.testData.OrderFormTestData;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest{
    CommonPage commonPage;
    HomePage homePage;
    LoginPage loginPage;
    ProductListingPage productListingPage;
    ProductDetailPage productDetailPage;
    OrderFormPage orderFormPage;

    @BeforeMethod
    public void setupPages() {
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productListingPage = new ProductListingPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        orderFormPage = new OrderFormPage(driver);
    }

    @Test
    public void ProductPurchaseSuccess() throws InterruptedException {
        commonPage.waitForElementVisibility(homePage.getLoginBtn());
        homePage.getLoginBtn().click();
        commonPage.validateURL(ConstantTestData.loginURL);

        loginPage.loginUser(LoginTestData.valid_USERNAME, LoginTestData.valid_PASSWORD);

        commonPage.waitForElementVisibility(homePage.getLogoutBtn());
        homePage.getHitProducts().click();
        commonPage.validateURL(ConstantTestData.hitProductListURL);

        productListingPage.clickRandomProductAndVerifyUrl();

        commonPage.waitForElementVisibility(productDetailPage.getBuyNowBtn());
        productDetailPage.getBuyNowBtn().click();
        commonPage.validateURL(ConstantTestData.orderFormURL);

        commonPage.waitForElementVisibility(orderFormPage.getSameOrderAddress());
        orderFormPage.getSameOrderAddress().click();
        orderFormPage.getBankTransferBtn().click();

        orderFormPage.fillBankAccountDetails(OrderFormTestData.depositerName, OrderFormTestData.depositerAccountNumber);

        commonPage.waitForElementVisibility(orderFormPage.getQRModal());
        Assert.assertTrue(orderFormPage.getQRModal().isDisplayed(), "QR Modal is not displayed in the modal");
        Assert.assertTrue(orderFormPage.getQRCodeImage().isDisplayed(), "QR CODE is not displayed in the modal");
    }
}
