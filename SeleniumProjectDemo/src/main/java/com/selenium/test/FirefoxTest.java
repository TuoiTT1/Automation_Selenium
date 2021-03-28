package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "F:\\program\\driver\\geckodriver.exe" );
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");

        WebElement textbox = driver.findElement(By.name("q"));
        textbox.sendKeys("hoa ban");
        textbox.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
    }
}
