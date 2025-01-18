package com.p2u.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    By userNameField = By.id("mb_id");
    By passwordField = By.id("mb_password");
    By loginBtn = By.id("form-submit1");
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

    public void loginUser(String username, String password){
        getUserNameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }
}
