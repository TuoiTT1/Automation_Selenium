package com.selenium.assignment3.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final int TIMEOUT=5;
    private static final int POLLING=100;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,TIMEOUT,POLLING);
        PageFactory.initElements(driver,this);
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
