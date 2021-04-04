package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercises1 {
    @Test
    public void test() {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.manage().window().maximize();

        WebElement message = driver.findElement(By.xpath("//label[@for=\"message\"]"));
        String messageText = message.getText();

        WebElement input = driver.findElement(By.id("user-message"));
        String placeholder = input.getAttribute("placeholder");

        WebElement header = driver.findElement(By.xpath("//div[text()='Single Input Field']"));
        String backgroundColor = header.getCssValue("background-color");
        try {
            Assert.assertEquals(messageText, "Enter message", "Fail...");
            Assert.assertEquals(placeholder, "Please enter your Message", "Fail...");
            Assert.assertEquals(backgroundColor, "rgba(51, 51, 51, 1)", "Fail...");
        } finally {
            driver.close();
        }
    }

    @Test
    public void bai1() {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.manage().window().maximize();

        String messageText = "Fresher Automation Tester";

        WebElement message = driver.findElement(By.id("user-message"));
        message.sendKeys(messageText);

        WebElement btn = driver.findElement(By.xpath("//form[@id='get-input']/button"));
        btn.click();

        message = driver.findElement(By.xpath("//div[@id='user-message']/span"));

        Assert.assertEquals(message.getText(), messageText, "Fail");

//        driver.close();
    }
}
