package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\TuoiTran\\git\\Automation_Selenium\\Automation_Selenium\\driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        WebElement textbox = driver.findElement(By.name("q"));
        textbox.sendKeys("hoa ban");
        textbox.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
    }
}
