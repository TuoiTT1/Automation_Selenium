package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercises6 {
    @Test
    public void exercises6() {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get(" http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        try {
            AppUtils.showPassOrFail("My Store".equals(driver.getTitle()));

            WebElement logo = driver.findElement(By.id("header_logo"));
            AppUtils.showPassOrFail(logo.isDisplayed());

            WebElement searchTextbox = driver.findElement(By.id("search_query_top"));
            WebElement searchButton = driver.findElement(By.xpath("//form[@id=\"searchbox\"]/button"));
            AppUtils.showPassOrFail(searchTextbox.isDisplayed() && searchButton.isDisplayed());

            WebElement cart = driver.findElement(By.className("shopping_cart"));
            AppUtils.showPassOrFail(cart.isDisplayed());

            WebElement menu = driver.findElement(By.id("block_top_menu"));
            AppUtils.showPassOrFail(menu.isDisplayed());

            WebElement contact = driver.findElement(By.id("contact-link"));
            AppUtils.showPassOrFail(contact.isDisplayed());

            WebElement signIn = driver.findElement(By.xpath("//div[@class=\"header_user_info\"]/a[@class=\"login\"]"));
            AppUtils.showPassOrFail(signIn.isDisplayed());

        } finally {
            driver.close();
        }

    }
}
