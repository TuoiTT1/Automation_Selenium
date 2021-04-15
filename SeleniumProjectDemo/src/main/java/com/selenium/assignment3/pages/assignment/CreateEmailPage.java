package com.selenium.assignment3.pages.assignment;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreateEmailPage extends BasePage {
    @FindBy(how = How.ID, using = "email_create")
    private WebElement email;

    @FindBy(how = How.XPATH, using = "//ol/li")
    private WebElement message;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement btnSubmitCreate;

    public CreateEmailPage(WebDriver driver) {
        super(driver);
    }

    public void navigate(String url){
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void inputEmail(String emailStr){
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(emailStr);
    }

    public void clickBtn() throws InterruptedException {
        btnSubmitCreate.click();
        Thread.sleep(4000);
    }

    public Boolean verify() {
        try{
            String msg = message.getText().trim();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();",message);

            if (msg.contains("Invalid email address.")) {
                return false;
            }
            if (msg.contains("this email address has already been registered")) {
                return false;
            }
            if (msg.contains("Invalid email address.")) {
                return false;
            }
        }catch (NoSuchElementException e){

        }

        return driver.getCurrentUrl().trim().equals("http://automationpractice.com/index.php?controller=authentication#account-creation");
    }

}
