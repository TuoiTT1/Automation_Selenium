package com.selenium.buoi1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercises5 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\program\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement element;
        element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[3]/div[1]/a"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
        element.click();

        Thread.sleep(5000);

        element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
        element.click();

        element = driver.findElement(By.id("email"));
        element.sendKeys("testselenium@gmail.com");
        element = driver.findElement(By.id("passwd"));
        element.sendKeys("Test@12345");
        element = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button"));
        element.click();

        Thread.sleep(10000);

    }
}
