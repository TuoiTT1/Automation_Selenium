package com.selenium.assignment3.pages.erp;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CreateMarketingCampaignPage extends BasePage {
    public CreateMarketingCampaignPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "EditMarketingCampaign_marketingCampaignId")
    private WebElement campaignId;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_parentCampaignId")
    private WebElement parentCampaignID;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_statusId")
    private WebElement status;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_campaignName")
    private WebElement campaignName;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_campaignSummary")
    private WebElement campaignSummary;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_budgetedCost")
    private WebElement budgetedCost;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_actualCost")
    private WebElement actualCost;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_estimatedCost")
    private WebElement estimatedCost;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_currencyUomId")
    private WebElement currencyUomId;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_fromDate_i18n")
    private WebElement fromDate;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_thruDate_i18n")
    private WebElement thruDate;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_isActive")
    private WebElement isActive;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_convertedLeads")
    private WebElement convertedLeads;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_expectedResponsePercent")
    private WebElement expectedResponsePercent;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_expectedRevenue")
    private WebElement expectedRevenue;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_numSent")
    private WebElement numSent;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_startDate_i18n")
    private WebElement startDate;

    @FindBy(how = How.ID, using = "EditMarketingCampaign_submitAction")
    private WebElement saveBtn;

    @FindBy(how = How.XPATH, using = "//ol/li")
    private WebElement message;

    public boolean verify(){
        List<WebElement> list = driver.findElements(By.tagName("label"));
        for (WebElement e: list) {
            if(!e.isDisplayed())
                return false;
        }
        return saveBtn.isDisplayed();
    }

    public void inputValue() throws InterruptedException {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(campaignId));
        campaignId.sendKeys("1111");
        Select select = new Select(parentCampaignID);
        select.selectByIndex(2);
        select = new Select(status);
        select.selectByVisibleText("Planned");
        campaignName.sendKeys("Test 1 Pay Per Click Advertising");
        campaignSummary.sendKeys("campaignSummary");
        budgetedCost.sendKeys("2000");
        actualCost.sendKeys("1900");
        estimatedCost.sendKeys("1500");
        select = new Select(currencyUomId);
        select.selectByVisibleText("American Dollar - USD");
        fromDate.sendKeys("2021-04-15");
        thruDate.sendKeys("2021-04-20");
        select = new Select(isActive);
        select.selectByValue("Y");
        convertedLeads.sendKeys("Converted Leads");
        expectedResponsePercent.sendKeys("80");
        expectedRevenue.sendKeys("80");
        numSent.sendKeys("100000");
        startDate.sendKeys("2021-04-15");

        saveBtn.click();
    }
    public boolean verifyCreate(){
        return message.getText().contains("Marketing Campaign created successfully");
    }
}
