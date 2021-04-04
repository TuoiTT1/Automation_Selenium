package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Exercises4_Select {
    @Test
    public void testSelect() throws InterruptedException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        driver.manage().window().maximize();

        Select select = new Select(driver.findElement(By.id("select-demo")));
        select.selectByIndex(1);
        Thread.sleep(5000);
        select.selectByValue("Thursday");
        Thread.sleep(5000);
        select.selectByVisibleText("Monday");
        Thread.sleep(5000);

        Select multiSelect = new Select(driver.findElement(By.id("multi-select")));
        multiSelect.selectByIndex(0);
        multiSelect.selectByValue("Florida");
        multiSelect.selectByVisibleText("Texas");
        Thread.sleep(5000);

        multiSelect.deselectByIndex(0);
        multiSelect.deselectByValue("Florida");
        multiSelect.deselectByVisibleText("Texas");
        Thread.sleep(5000);

    }
}
