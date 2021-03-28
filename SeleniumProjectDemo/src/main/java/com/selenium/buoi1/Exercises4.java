package com.selenium.buoi1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercises4 {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\program\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");


        WebElement tr = driver.findElement(By.xpath("//table[@id='customers']//tr[td=\"UK\"]"));
        System.out.println(tr.getText());

        WebElement td = driver.findElement(By.xpath("//table[@id='customers']//tr[last()]"));
        System.out.println(td.getText());



    }
}
