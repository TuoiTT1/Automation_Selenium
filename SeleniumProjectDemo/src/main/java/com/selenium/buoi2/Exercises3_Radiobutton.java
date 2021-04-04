package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Exercises3_Radiobutton {
    @Test
    public void testRadioButton() throws InterruptedException, IOException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        driver.manage().window().maximize();

        WebElement radioBtn = driver.findElement(By.xpath("(//input[@value=\"Male\"])[2]"));
        if(!radioBtn.isSelected()){
            radioBtn.click();
        }
        radioBtn = driver.findElement(By.xpath("(//input[@value=\"5 - 15\"])"));
        if(!radioBtn.isSelected()){
            radioBtn.click();
        }
        WebElement btnGetValue = driver.findElement(By.xpath("(//div[@class=\"panel-body\"])[3]/button"));
        btnGetValue.click();


        WebElement message = driver.findElement(By.className("groupradiobutton"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", message);

        String messageText = message.getText();
        if(messageText.contains("Sex : Male") && messageText.contains("Age group: 5 - 15")){
            System.out.println("OK");
        } else {
            System.out.println("NG");
        }
        AppUtils.takeScreenshot(driver, "testRadioButton");
    }
}
