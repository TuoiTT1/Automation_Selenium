package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class InternetExplorerTest {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.ie.driver",
                "F:\\program\\driver\\IEDriverServer.exe" );
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://google.com");

        WebElement textbox = driver.findElement(By.name("q"));
        textbox.sendKeys("hoa ban");
        textbox.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
    }
}
