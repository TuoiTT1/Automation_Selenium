package com.selenium.assignment3.pages.assignment;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ProductAmazonPage extends BasePage {
    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement searchTextbox;
    @FindBy(how = How.ID, using = "searchDropdownBox")
    private WebElement searchDropDown;
    @FindBy(how = How.ID, using = "nav-search-submit-button")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[1]/div/div/span/a")
    private WebElement firstResult;
    @FindBy(how = How.ID, using = "productTitle")
    private WebElement productTitle;

    public ProductAmazonPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProductPage(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void selectCategory(String category) throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(searchDropDown);
        select.selectByVisibleText(category);
    }

    public void inputSearchKey(String searchKey) {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(searchTextbox));
        searchTextbox.sendKeys(searchKey);
    }

    public void clickGo() {
        searchButton.click();
    }

    public void clickFirstResult() {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(firstResult));
        firstResult.click();
    }

    public boolean verify(String productTitleStr) {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(productTitle));
        return productTitleStr.equals(productTitle.getText().trim());
    }
}
