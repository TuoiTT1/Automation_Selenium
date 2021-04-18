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

public class CreateMarketingCampaignPageTest extends BaseTest {

    public static final String url = "https://ce.scipioerp.com/crm";
    public static TestCase testCase = new TestCase();

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
                testCase = new TestCase("", "", "PASS");
            } else {
                testCase = new TestCase("", "", "FAIL");
                Assert.fail("Verify Create Marketing Campaign page Fail");
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
            writeResult("test_data\\ERPTestcase.xlsx", "output\\ERPTestcaseResult.xlsx", testCase, 5, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
