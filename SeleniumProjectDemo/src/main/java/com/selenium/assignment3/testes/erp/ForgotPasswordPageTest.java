package com.selenium.assignment3.testes.erp;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.pages.erp.ForgotPasswordPage;
import com.selenium.assignment3.pages.erp.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class ForgotPasswordPageTest extends BaseTest {
    public static final String url = "https://ce.scipioerp.com/crm";
    public static TestCase testCase = new TestCase();

    @Test()
    public void forgotPwdPageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.navigate(url);
            if (loginPage.verifyLoginPage()) {
                loginPage.clickForgotPassword();

                ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());

                if (forgotPasswordPage.verifyForgotPasswordPage()) {
                    testCase = new TestCase("", "", "PASS");
                } else {
                    testCase = new TestCase("", "", "Fail");
                    Assert.fail("verify Login Page is fail...");
                }
            } else {
                testCase = new TestCase("", "", "Fail");
                Assert.fail("Verify Login Page is fail...");
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
            writeResult("test_data\\ERPTestcase.xlsx", "output\\ERPTestcaseResult.xlsx", testCase, 2, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
