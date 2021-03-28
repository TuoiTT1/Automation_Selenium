package com.selenium.buoi1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercises1 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\program\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/majorleague/control/newcustomer");

        WebElement textBox;
        textBox = driver.findElement(By.name("CUSTOMER_EMAIL"));
        textBox.sendKeys("test@gmail.com");

        textBox = driver.findElement(By.name("USERNAME"));
        textBox.sendKeys("test1");

        textBox = driver.findElement(By.name("PASSWORD"));
        textBox.sendKeys("123456");

        textBox = driver.findElement(By.name("CONFIRM_PASSWORD"));
        textBox.sendKeys("123456");

        textBox = driver.findElement(By.name("PASSWORD_HINT"));
        textBox.sendKeys("123456");

        textBox = driver.findElement(By.name("CUSTOMER_ADDRESS1"));
        textBox.sendKeys("address1");

        textBox = driver.findElement(By.name("CUSTOMER_ADDRESS2"));
        textBox.sendKeys("address2");

        textBox = driver.findElement(By.name("CUSTOMER_CITY"));
        textBox.sendKeys("Hà Nội");

        textBox = driver.findElement(By.name("CUSTOMER_POSTAL_CODE"));
        textBox.sendKeys("9999");

//        textBox = driver.findElement(By.name("USER_FIRST_NAME"));
        textBox = driver.findElement(By.xpath("//*[@id=\"USER_FIRST_NAME\"]"));
        textBox.sendKeys("First");

        textBox = driver.findElement(By.cssSelector("#USER_MIDDLE_NAME"));
        textBox.sendKeys("Middle");

        textBox = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div[3]/div/div/div[1]/form/div[2]/div[2]/fieldset/div[4]/div[2]/input"));
        textBox.sendKeys("Last");

        textBox = driver.findElement(By.name("USER_SUFFIX"));
        textBox.sendKeys("Test1");

        textBox = driver.findElement(By.name("CUSTOMER_HOME_COUNTRY"));
        textBox.sendKeys("Ha Nam");

        textBox = driver.findElement(By.name("CUSTOMER_HOME_AREA"));
        textBox.sendKeys("Ha Noi");

        textBox = driver.findElement(By.name("CUSTOMER_HOME_CONTACT"));
        textBox.sendKeys("123456");

        textBox = driver.findElement(By.name("CUSTOMER_HOME_EXT"));
        textBox.sendKeys("Ha Noi");

        textBox = driver.findElement(By.name("CUSTOMER_WORK_COUNTRY"));
        textBox.sendKeys("Hòa Lạc");

        textBox = driver.findElement(By.id("field_id__29"));
        textBox.sendKeys("a");

        textBox = driver.findElement(By.id("field_id__30"));
        textBox.sendKeys("b");

        textBox = driver.findElement(By.id("field_id__31"));
        textBox.sendKeys("c");

        textBox = driver.findElement(By.id("field_id__34"));
        textBox.sendKeys("d");

        textBox = driver.findElement(By.id("field_id__35"));
        textBox.sendKeys("f");

        textBox = driver.findElement(By.id("field_id__36"));
        textBox.sendKeys("g");

        textBox = driver.findElement(By.id("field_id__39"));
        textBox.sendKeys("h");

        textBox = driver.findElement(By.id("field_id__40"));
        textBox.sendKeys("i");

        textBox = driver.findElement(By.id("field_id__41"));
        textBox.sendKeys("k");

        Thread.sleep(10000);
    }
}
