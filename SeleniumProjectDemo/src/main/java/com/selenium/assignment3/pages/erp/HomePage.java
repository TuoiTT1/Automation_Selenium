package com.selenium.assignment3.pages.erp;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(how = How.ID, using = "menu_1")
    private WebElement leftMenu;
    @FindBy(how = How.ID, using = "chart_2_1")
    private WebElement grossChart;
    @FindBy(how = How.XPATH, using = "//h2[text()='Best Selling Products']")
    private WebElement bestSellingProducts;
    @FindBy(how = How.XPATH, using = "//h2[text()='Registrations']")
    private WebElement registrations;
    @FindBy(how = How.XPATH, using = "//h2[text()='Last Communication']")
    private WebElement lastCommunication;
    @FindBy(how = How.XPATH, using = "//h2[text()='List Marketing Campaign']")
    private WebElement listMarketingCampaign;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean verify() {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(leftMenu));

        return leftMenu.isDisplayed() &&
                grossChart.isDisplayed() &&
                bestSellingProducts.isDisplayed() &&
                registrations.isDisplayed() &&
                lastCommunication.isDisplayed() &&
                listMarketingCampaign.isDisplayed();
    }
}
