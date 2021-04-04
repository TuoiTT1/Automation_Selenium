package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Exercises9_DragDrop {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropTarget = driver.findElement(By.id("droptarget"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", dropTarget);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropTarget).perform();
    }
    @Test
    public void exercises9(){
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        WebElement draggable = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        WebElement dropTarget = driver.findElement(By.id("amt7"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropTarget).perform();

    }

}
