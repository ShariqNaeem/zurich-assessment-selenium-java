package com.saucedemo.tests;

import com.saucedemo.testData.ConstantTestData;
import com.saucedemo.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginUserTest extends BaseTest{

    // DataProvider method to read data from Excel
    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        ExcelUtils.setExcelFile(ConstantTestData.loginExcelFilePath, ConstantTestData.loginExcelSheetName);
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0);
            data[i - 1][1] = ExcelUtils.getCellData(i, 1);
        }
        ExcelUtils.closeExcelFile();
        return data;
    }
    @Test(dataProvider = "loginData")
    public void loginUserByPageFactory(String username, String password){
        loginPageFactory.getUserNameField().sendKeys(username);
        loginPageFactory.getPasswordField().sendKeys(password);
        loginPageFactory.getLoginBtn().click();

        Assert.assertTrue(inventoryPageFactory.getCartIcon().isDisplayed());
        commonPageFactory.validateURL(ConstantTestData.inventoryURL);
    }
}
