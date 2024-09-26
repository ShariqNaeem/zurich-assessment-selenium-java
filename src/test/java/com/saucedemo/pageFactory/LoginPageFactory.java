package com.saucedemo.pageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageFactory {
    private WebDriver driver;
    // Use @FindBy annotation to locate elements
    @FindBy(css = "[data-test=\"username\"]")
    private WebElement userNameField;

    @FindBy(css = "[data-test=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = "[data-test=\"login-button\"]")
    private WebElement loginBtn;

    @FindBy(className = "error-message-container")
    private WebElement errorMsg;

    // Constructor initializes the PageFactory elements
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }
}
