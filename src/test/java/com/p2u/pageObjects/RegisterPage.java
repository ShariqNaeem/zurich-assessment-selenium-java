package com.p2u.pageObjects;

import com.p2u.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    By allAgreeBtn = By.id("agree_all_2");
    By agreeToTermsAndConditions = By.id("register-submit-one");
    By idRegistration = By.id("reg_mb_id");
    By passwordRegistration = By.id("reg_mb_password");
    By verifyPasswordRegistration = By.id("reg_mb_password_re");
    By nameRegistration = By.id("reg_mb_name");
    By nickNameRegistration = By.id("reg_mb_nick");
    By emailRegistration = By.id("reg_mb_email");
    By phoneRegistration = By.id("reg_mb_hp");
    By zipcodeRegistration = By.id("reg_mb_zip");
    By address1Registration = By.id("reg_mb_addr1");
    By address2Registration = By.id("reg_mb_addr2");
    By joinTheMembershipBtn = By.id("btn_submit");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAllAgreeBtn() {
        return driver.findElement(allAgreeBtn);
    }

    public WebElement getAgreeToTermsAndConditionsField() {
        return driver.findElement(agreeToTermsAndConditions);
    }

    public WebElement getIdRegistration() {
        return driver.findElement(idRegistration);
    }

    public WebElement getPasswordRegistration() {
        return driver.findElement(passwordRegistration);
    }

    public WebElement getVerifyPasswordRegistration() {
        return driver.findElement(verifyPasswordRegistration);
    }

    public WebElement getNameRegistration() {
        return driver.findElement(nameRegistration);
    }

    public WebElement getNickNameRegistration() {
        return driver.findElement(nickNameRegistration);
    }

    public WebElement getEmailRegistration() {
        return driver.findElement(emailRegistration);
    }

    public WebElement getPhoneRegistration() {
        return driver.findElement(phoneRegistration);
    }

    public WebElement getZipcodeRegistration() {
        return driver.findElement(zipcodeRegistration);
    }

    public WebElement getAddress1Registration() {
        return driver.findElement(address1Registration);
    }

    public WebElement getAddress2Registration() {
        return driver.findElement(address2Registration);
    }

    public WebElement getJoinTheMembershipBtn() {
        return driver.findElement(joinTheMembershipBtn);
    }

    public void fillRegistrationFormWithRandomData() {
        // Generate random data
        String randomId = RandomUtils.generateRandomString(null).substring(0, 5);
        String randomPassword = "Password123";
        String randomName = RandomUtils.generateRandomString("Name");
        String randomNickName = RandomUtils.generateRandomString("Nick");
        String randomEmail = RandomUtils.generateRandomEmail();
        String randomPhone = RandomUtils.generateRandomPhoneNumber();
        String randomZipcode = "12345";
        String randomAddress1 = "123 Test Street";
        String randomAddress2 = "Apt 456";

        // Fill form fields
        getIdRegistration().sendKeys(randomId);
        getPasswordRegistration().sendKeys(randomPassword);
        getVerifyPasswordRegistration().sendKeys(randomPassword);
        getNameRegistration().sendKeys(randomName);
        getNickNameRegistration().sendKeys(randomNickName);
        getEmailRegistration().sendKeys(randomEmail);
        getPhoneRegistration().sendKeys(randomPhone);
        getZipcodeRegistration().sendKeys(randomZipcode);
        getAddress1Registration().sendKeys(randomAddress1);
        getAddress2Registration().sendKeys(randomAddress2);

        // Submit the form
        getJoinTheMembershipBtn().click();
    }
}
