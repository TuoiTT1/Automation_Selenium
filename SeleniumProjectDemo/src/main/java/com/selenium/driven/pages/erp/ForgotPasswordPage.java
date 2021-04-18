package com.selenium.assignment3.pages.erp;

import com.selenium.assignment3.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends BasePage {
    @FindBy(how = How.ID, using = "field_id__1")
    private WebElement userName;
    @FindBy(how = How.ID, using = "field_id__2")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//a[text()='Go Back']")
    private WebElement goBack;
    @FindBy(how = How.ID, using = "field_id__3")
    private WebElement emailPassword;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public Boolean verifyForgotPasswordPage() {
        return "User Name".equals(userName.getAttribute("placeholder")) &&
                goBack.isDisplayed() &&
                password.isDisplayed() &&
                emailPassword.isDisplayed();
    }
}
