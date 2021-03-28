package com.selenium.buoi1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercises3 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\program\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/humanres/control/NewEmployee");

        WebElement txtBox;
        WebElement btnClick;
        txtBox = driver.findElement(By.id("field_id__1"));
        txtBox.sendKeys("admin");

        txtBox = driver.findElement(By.id("field_id__2"));
        txtBox.sendKeys("scipio");

        btnClick = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/form/input[2]"));
        btnClick.click();

        txtBox = driver.findElement(By.id("NewEmployee_salutation"));
        txtBox.sendKeys("Create new employee");

        txtBox = driver.findElement(By.id("NewEmployee_firstName"));
        txtBox.sendKeys("Tung");

        txtBox = driver.findElement(By.id("NewEmployee_middleName"));
        txtBox.sendKeys("Hoang");

        txtBox = driver.findElement(By.id("NewEmployee_lastName"));
        txtBox.sendKeys("Tran");

        txtBox = driver.findElement(By.id("NewEmployee_fromDate_i18n"));
        txtBox.sendKeys("2021/02/01");

        txtBox = driver.findElement(By.id("NewEmployee_address1"));
        txtBox.sendKeys("Thanh Tri");

        txtBox = driver.findElement(By.id("NewEmployee_address2"));
        txtBox.sendKeys("Duy Tan");

        txtBox = driver.findElement(By.id("NewEmployee_city"));
        txtBox.sendKeys("Ha Noi");

        txtBox = driver.findElement(By.id("NewEmployee_postalCode"));
        txtBox.sendKeys("30");


        txtBox = driver.findElement(By.id("NewEmployee_countryCode"));
        txtBox.sendKeys("84");


        txtBox = driver.findElement(By.id("NewEmployee_areaCode"));
        txtBox.sendKeys("9999");


        txtBox = driver.findElement(By.id("NewEmployee_contactNumber"));
        txtBox.sendKeys("123456789");

        txtBox = driver.findElement(By.id("NewEmployee_extension"));
        txtBox.sendKeys("2222");

        txtBox = driver.findElement(By.id("NewEmployee_emailAddress"));
        txtBox.sendKeys("tung@test.com");

        btnClick = driver.findElement(By.id("NewEmployee_submitAction"));
        btnClick.click();

        Thread.sleep(10000);
    }

}
