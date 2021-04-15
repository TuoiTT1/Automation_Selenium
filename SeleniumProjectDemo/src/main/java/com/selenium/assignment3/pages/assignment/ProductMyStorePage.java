package com.selenium.assignment3.pages.assignment;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductMyStorePage extends BasePage {

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchTextBox;

    @FindBy(how = How.XPATH, using = "//form[@id='searchbox']/button")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "(//div[@class=\"product-image-container\"])[1]/a")
    private WebElement firstResult;

    @FindBy(how = How.XPATH, using = "//h1")
    private WebElement productName;

    @FindBy(how = How.XPATH, using = "//span[@itemprop=\"price\"]")
    private WebElement price;

    @FindBy(how = How.XPATH, using = "//p[@id=\"add_to_cart\"]/button")
    private WebElement addToCartBtn;

    @FindBy(how = How.XPATH, using = "//h2/span[2]")
    private WebElement cartProductText;

    @FindBy(how = How.XPATH, using = "//td[@class=\"cart_description\"]/p/a")
    private WebElement productNameInCart;

    public ProductMyStorePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProductPage(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void search(String key) {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(searchTextBox));
        searchTextBox.sendKeys(key);
    }

    public void clickSearchBtn() throws InterruptedException {
        searchButton.click();
        Thread.sleep(3000);
    }

    public void clickFirstResult() throws InterruptedException {
        firstResult.click();
        Thread.sleep(3000);
    }

    public boolean verify(String productTitleStr, String priceStr) {
        return (productTitleStr.equals(productName.getText().trim()) && ("$" + priceStr).equals(price.getText().trim()));
    }

    public void clickAddToCartBtn() throws InterruptedException {
        addToCartBtn.click();
        Thread.sleep(4000);
    }

    public boolean verifyText(String text){
        return text.equals(cartProductText.getText().trim());
    }

    public boolean verifyCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",productNameInCart);
        return productNameInCart.isDisplayed();
    }
}
