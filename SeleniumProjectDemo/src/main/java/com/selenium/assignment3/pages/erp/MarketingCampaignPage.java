package com.selenium.assignment3.pages.erp;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MarketingCampaignPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"menu_1\"]/li[5]/a")
    private WebElement marketingBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='field_id__1']")
    private WebElement campaignId;

    @FindBy(how = How.ID, using = "field_id__2")
    private WebElement campaignName;

    @FindBy(how = How.XPATH, using = "//label[@for='field_id__2']")
    private WebElement campaignNameLabel;
    @FindBy(how = How.XPATH, using = "//label[@for='field_id__3']")
    private WebElement parentCampaignId;

    @FindBy(how = How.XPATH, using = "//label[@for='field_id__4']")
    private WebElement status;

    @FindBy(how = How.ID, using = "field_id__5")
    private WebElement findBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='button-bar']/a")
    private WebElement createMarketingCampaign;

    @FindBy(how = How.XPATH, using = "(//td/a)[1]")
    private WebElement campaignIdResult;

    @FindBy(how = How.XPATH, using = "(//td)[2]")
    private WebElement campaignNameResult;

    public MarketingCampaignPage(WebDriver driver) {
        super(driver);
    }

    public void clickMarketing() throws InterruptedException {
        marketingBtn.click();
        Thread.sleep(4000);
    }

    public boolean verify() {
        return campaignId.isDisplayed() &&
                campaignNameLabel.isDisplayed() &&
                parentCampaignId.isDisplayed() &&
                status.isDisplayed() &&
                findBtn.isDisplayed();
    }

    public void clickCreate() throws InterruptedException {
        createMarketingCampaign.click();
        Thread.sleep(4000);
    }

    public void navigate(String url) {
        driver.navigate().to(url);

    }

    public boolean search(String campaignIDStr, String campaignNameStr) throws InterruptedException {
        campaignName.sendKeys(campaignNameStr);
        findBtn.click();
        Thread.sleep(6000);

        return campaignIdResult.isDisplayed() &&
                campaignNameResult.isDisplayed();
    }
}
