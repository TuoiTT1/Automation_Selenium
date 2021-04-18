package com.selenium.assignment3.testes.erp;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.pages.erp.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends BaseTest {

    public static final String url = "https://ce.scipioerp.com/crm";
    public static TestCase testCase = new TestCase();

    @Test()
    public void loginPageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.navigate(url);
            if (loginPage.verifyLoginPage()) {
                testCase = new TestCase("", "", "PASS");
            } else {
                testCase = new TestCase("", "", "Fail");
                Assert.fail("verify Login Page is fail...");
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
            writeResult("test_data\\ERPTestcase.xlsx", "output\\ERPTestcaseResult.xlsx", testCase, 1, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
