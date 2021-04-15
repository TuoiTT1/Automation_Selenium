package com.selenium.assignment3.testes.erp;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.ExcelUtils;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.core.TestListener;
import com.selenium.assignment3.pages.erp.*;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class ERPTestALL extends BaseTest {

    public static final String url = "https://ce.scipioerp.com/crm";
    public static List<TestCase> testCaseList = new ArrayList<>();

    @BeforeSuite
    @Override
    public void beforeSuite() {
        super.beforeSuite();
        testCaseList.add(new TestCase("ID", "Test Case Title", "Result"));
    }

    @Test()
    public void loginPageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.navigate(url);
            if (loginPage.verifyLoginPage()) {
                testCaseList.add(new TestCase("TC_01", "Verify Login Page", "PASS"));
            } else {
                testCaseList.add(new TestCase("TC_01", "Verify Login Page", "Fail"));
                Assert.fail("verify Login Page is fail...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void forgotPwdPageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.navigate(url);
            if (loginPage.verifyLoginPage()) {
                loginPage.clickForgotPassword();

                ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());

                if (forgotPasswordPage.verifyForgotPasswordPage()) {
                    testCaseList.add(new TestCase("TC_02", "Verify Forgot Password", "PASS"));
                } else {
                    testCaseList.add(new TestCase("TC_02", "Verify Forgot Password", "Fail"));
                    Assert.fail("verify Login Page is fail...");
                }
            } else {
                testCaseList.add(new TestCase("TC_02", "Verify Forgot Password", "Fail"));
                Assert.fail("Verify Login Page is fail...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void homePageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigate(url);
        try {
            loginPage.login();
            HomePage homePage = new HomePage(getDriver());
            if (homePage.verify()) {
                testCaseList.add(new TestCase("TC_03", "Verify Home Page", "PASS"));
            } else {
                testCaseList.add(new TestCase("TC_03", "Verify Home Page", "Fail"));
                Assert.fail("Verify Home Page is fail...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            getDriver().manage().deleteAllCookies();
        }
    }

    @Test
    public void marketingCampaignPageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigate(url);
        try {
            loginPage.login();

            MarketingCampaignPage marketingCampaignPage = new MarketingCampaignPage(getDriver());
            marketingCampaignPage.clickMarketing();
            if (marketingCampaignPage.verify()) {
                testCaseList.add(new TestCase("TC_04", "Verify Marketing Campaign page", "PASS"));
            } else {
                testCaseList.add(new TestCase("TC_04", "Verify Marketing Campaign page", "FAIL"));
                Assert.fail("Verify Marketing Campaign page Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            getDriver().manage().deleteAllCookies();
        }
    }

    @Test
    public void createMarketingCampaignPageTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigate(url);
        try {
            loginPage.login();

            MarketingCampaignPage marketingCampaignPage = new MarketingCampaignPage(getDriver());
            marketingCampaignPage.clickMarketing();
            marketingCampaignPage.clickCreate();

            CreateMarketingCampaignPage createMarketingCampaignPage = new CreateMarketingCampaignPage(getDriver());
            if (createMarketingCampaignPage.verify()) {
                testCaseList.add(new TestCase("TC_05", "Verify Create Marketing Campaign page", "PASS"));
            } else {
                testCaseList.add(new TestCase("TC_05", "Verify Create Marketing Campaign page", "FAIL"));
                Assert.fail("Verify Create Marketing Campaign page Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            getDriver().manage().deleteAllCookies();
        }
    }

    @Test
    public void createMarketingCampaignSuccessfullyTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigate(url);

        try {
            loginPage.login();
            MarketingCampaignPage marketingCampaignPage = new MarketingCampaignPage(getDriver());
            marketingCampaignPage.clickMarketing();
            marketingCampaignPage.clickCreate();
            CreateMarketingCampaignPage cmcs = new CreateMarketingCampaignPage(getDriver());
            cmcs.inputValue();
            Thread.sleep(6000);
            if (cmcs.verifyCreate()) {
                marketingCampaignPage.navigate("https://ce.scipioerp.com/crm/control/FindMarketingCampaign");
                if (marketingCampaignPage.search("1111", "Test 1 Pay Per Click Advertising")) {
                    testCaseList.add(new TestCase("TC_06", "Verify Create Marketing Campaign successfully", "PASS"));
                } else {
                    testCaseList.add(new TestCase("TC_06", "Verify Create Marketing Campaign successfully", "FAIL"));
                    Assert.fail("Verify Create Marketing Campaign successfully Fail");
                }
            } else {
                testCaseList.add(new TestCase("TC_05", "Verify Create Marketing Campaign successfully", "FAIL"));
                Assert.fail("Verify Create Marketing Campaign is Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           getDriver().manage().deleteAllCookies();
        }
    }

    @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            ExcelUtils.writeExcel(testCaseList, "output\\ERPTestOutput.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
