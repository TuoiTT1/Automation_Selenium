package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Exercises11_ContextMenu {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://demos.telerik.com/kendo-ui/menu/context-menu");
//        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        WebElement title = driver.findElement(By.xpath("(//h3[text()='RE: New version of Telerik Trainer'])[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", title);

        WebElement label = driver.findElement(By.xpath("(//span[contains(text(),\"Label\")])[1]"));
        Actions actions = new Actions(driver);
        actions.contextClick(title).moveToElement(label).click().perform();
    }
}
