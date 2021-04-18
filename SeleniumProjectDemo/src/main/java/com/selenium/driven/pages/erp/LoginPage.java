package com.selenium.assignment3.pages.erp;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(how = How.ID, using = "field_id__1")
    private WebElement userName;
    @FindBy(how = How.ID, using = "field_id__2")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//input[@value=\"Login\"]")
    private WebElement loginBtn;
    @FindBy(how = How.XPATH, using = "//small/a")
    private WebElement forgotPassword;
    @FindBy(how = How.XPATH, using = "//a[text()='Go Back']")
    private WebElement goBack;
    @FindBy(how = How.ID, using = "field_id__3")
    private WebElement emailPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigate(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public Boolean verifyLoginPage() {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(userName));

        return ("User Name".equals(userName.getAttribute("placeholder"))) &&
                ("Password".equals(password.getAttribute("placeholder"))) &&
                loginBtn.isDisplayed() &&
                forgotPassword.isDisplayed();
    }

    public void login() throws InterruptedException {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(userName));

        userName.sendKeys("admin");
        password.sendKeys("scipio");
        loginBtn.click();
        Thread.sleep(4000);
    }

    public void clickForgotPassword() {
        forgotPassword.click();
    }

}
