package com.p2u.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFormPage {
    private WebDriver driver;
    By sameOrderAddress = By.id("ad_sel_addr_same");
    By bankTransferBtn = By.cssSelector("label[for=\"od_settle_bank\"]");
    By depositName = By.id("od_deposit_name");
    By depositBankAccount = By.id("od_refund_bank");
    By orderNowBtn = By.cssSelector("input.btn_submit.payment-button-bank");
    By qrModal = By.id("p2u-modal");
    By qrCode = By.id("p2u-qr-code-image");


    public OrderFormPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getSameOrderAddress() {
        return driver.findElement(sameOrderAddress);
    }
    public WebElement getBankTransferBtn() {
        return driver.findElement(bankTransferBtn);
    }
    public WebElement getDepositName() {
        return driver.findElement(depositName);
    }
    public WebElement getDepositBankAccount() {
        return driver.findElement(depositBankAccount);
    }
    public WebElement getOrderNowBtn() {
        return driver.findElement(orderNowBtn);
    }
    public WebElement getQRModal() {
        return driver.findElement(qrModal);
    }
    public WebElement getQRCodeImage() {
        return driver.findElement(qrCode);
    }

    public void fillBankAccountDetails(String depositNameValue, String depositBankAccountValue) {
        // Fill the deposit name
        WebElement depositNameField = getDepositName();
        depositNameField.clear();
        depositNameField.sendKeys(depositNameValue);

        // Fill the deposit bank account
        WebElement depositBankAccountField = getDepositBankAccount();
        depositBankAccountField.clear();
        depositBankAccountField.sendKeys(depositBankAccountValue);

        getOrderNowBtn().click();
    }
}
