package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Exercises2_Checkbox {
    @Test
    public void testCheckbox() throws InterruptedException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();

        WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        List<WebElement> listCheckbox = driver.findElements(By.className("cb1-element"));
        listCheckbox.forEach(cb ->{
            if(!cb.isSelected()){
                cb.click();
            }
        });

        for(int i = 1; i<=listCheckbox.size(); i = i+2){
            listCheckbox.get(i).click();
        }
    }
}
