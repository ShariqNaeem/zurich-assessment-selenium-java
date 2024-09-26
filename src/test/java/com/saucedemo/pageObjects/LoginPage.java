package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    By userNameField = By.cssSelector("[data-test=\"username\"]");
    By passwordField = By.cssSelector("[data-test=\"password\"]");
    By loginBtn = By.cssSelector("[data-test=\"login-button\"]");
    By errorMsg = By.className("error-message-container");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getUserNameField() {
        return driver.findElement(userNameField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getLoginBtn() {
        return driver.findElement(loginBtn);
    }

    public WebElement getErrorMsg() {
        return driver.findElement(errorMsg);
    }
}
