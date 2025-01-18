package com.p2u.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    By loginBtn = By.cssSelector("a.single-line-button3.mobile-active-right");
    By mainSlider = By.cssSelector("section.main-wrapper div.hero-left");
    By logoutBtn = By.cssSelector("a[href=\"https://dev.p2u.kr/bbs/logout.php\"]");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getLoginBtn() {
        return driver.findElement(loginBtn);
    }
    public WebElement getMainSlider() {
        return driver.findElement(mainSlider);
    }
    public WebElement getLogoutBtn() {
        return driver.findElement(logoutBtn);
    }
}
