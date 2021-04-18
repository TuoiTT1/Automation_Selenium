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

public class LoginPage extends BasePage {
    @FindBy(how = How.ID, using = "email")
    private WebElement email;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement password;
    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement login;
    @FindBy(how = How.XPATH, using = "//a[@title='Log me out']")
    private WebElement logout;
    @FindBy(how = How.XPATH, using = "//ol/li")
    private WebElement messageError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigate(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void clickLogin() {
        login.click();
    }

    public void login(String emailInput, String passwordInput) {
        getWait().withTimeout(Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(emailInput);
        password.sendKeys(passwordInput);
    }

    public boolean verify() {
        try {
            if (logout.isDisplayed()) {
                logout.click();
                return true;
            }
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
        }
        try {
            String msg = messageError.getText().trim();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();",messageError);

            if (msg.contains("Authentication failed.")) {
                return false;
            }
            if (msg.contains("Invalid email address.")) {
                return false;
            }
            if (msg.contains("An email address required.")) {
                return false;
            }
            return !msg.contains("Password is required.");
        } catch (NoSuchElementException e) {

        }
        return false;
    }

}
