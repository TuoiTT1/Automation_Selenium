package com.selenium.assignment3.testes.erp;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.pages.erp.CreateMarketingCampaignPage;
import com.selenium.assignment3.pages.erp.LoginPage;
import com.selenium.assignment3.pages.erp.MarketingCampaignPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateMarketingCampaignSuccessfullyTest extends BaseTest {

    public static final String url = "https://ce.scipioerp.com/crm";
    public static TestCase testCase = new TestCase();

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
                    testCase = new TestCase("TC_06", "Verify Create Marketing Campaign successfully", "PASS");
                } else {
                    testCase = new TestCase("TC_06", "Verify Create Marketing Campaign successfully", "FAIL");
                    Assert.fail("Verify Create Marketing Campaign successfully Fail");
                }
            } else {
                testCase = new TestCase("TC_05", "Verify Create Marketing Campaign successfully", "FAIL");
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
            writeResult("test_data\\ERPTestcase.xlsx", "output\\ERPTestcaseResult.xlsx", testCase, 6, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
