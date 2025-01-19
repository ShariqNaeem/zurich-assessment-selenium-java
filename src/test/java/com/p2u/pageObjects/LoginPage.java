package com.p2u.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    By userNameField = By.id("mb_id");
    By passwordField = By.id("mb_password");
    By loginBtn = By.id("form-submit1");
    By registerBtn = By.cssSelector("a[href=\"https://dev.p2u.kr/bbs/register.php\"]");
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
    public WebElement getRegisterBtn() {
        return driver.findElement(registerBtn);
    }

    public void loginUser(String username, String password){
        getUserNameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }
}
