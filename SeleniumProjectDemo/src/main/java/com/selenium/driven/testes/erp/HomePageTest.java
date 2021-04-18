package com.selenium.assignment3.testes.erp;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.pages.erp.HomePage;
import com.selenium.assignment3.pages.erp.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseTest {
    public static final String url = "https://ce.scipioerp.com/crm";
    public static TestCase testCase = new TestCase();

    @Test
    public void homePageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigate(url);
        try {
            loginPage.login();
            HomePage homePage = new HomePage(getDriver());
            if (homePage.verify()) {
                testCase = new TestCase("", "", "PASS");
            } else {
                testCase = new TestCase("", "", "Fail");
                Assert.fail("Verify Home Page is fail...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            writeResult("test_data\\ERPTestcase.xlsx", "output\\ERPTestcaseResult.xlsx", testCase, 3, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
