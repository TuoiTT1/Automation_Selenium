package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Exercises5_Table {
    @Test
    public void testTable() throws InterruptedException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.id("myTable"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement element : rows) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }
    }
}
