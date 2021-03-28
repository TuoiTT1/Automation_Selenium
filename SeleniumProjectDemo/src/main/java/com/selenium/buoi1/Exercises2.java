package com.selenium.buoi1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercises2 {
    @Test
    public void testId() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\program\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement searchBox;
        searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("search by id");

        Thread.sleep(10000);

    }

    @Test
    public void testName() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\program\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement searchBox;

        searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("search by name");

        Thread.sleep(10000);

    }

    @Test
    public void testXpath1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\program\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement searchBox;

        searchBox = driver.findElement(By.xpath("//input[contains(@class,\"search_query\")]"));
        searchBox.sendKeys("dress");

        WebElement btnClick = driver.findElement(By.xpath("//button[contains(@class,\"search\")]"));
        btnClick.click();
        Thread.sleep(10000);

    }

}
