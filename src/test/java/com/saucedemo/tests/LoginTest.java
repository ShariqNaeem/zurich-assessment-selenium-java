package com.saucedemo.tests;

import com.saucedemo.testData.ConstantTestData;
import com.saucedemo.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest{

    // DataProvider method to read data from Excel
    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        ExcelUtils.setExcelFile(ConstantTestData.loginExcelFilePath, ConstantTestData.loginExcelSheetName);
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][2];  // Assuming 2 columns for test data

        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Column 1
            data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Column 2
        }
        ExcelUtils.closeExcelFile();
        return data;
    }
    @Test(dataProvider = "loginData")
    public void loginSuccess(String username, String password){
        loginPage.getUserNameField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginBtn().click();

        Assert.assertTrue(inventoryPage.getCartIcon().isDisplayed());
        commonPage.validateURL(ConstantTestData.inventoryURL);
    }
}
