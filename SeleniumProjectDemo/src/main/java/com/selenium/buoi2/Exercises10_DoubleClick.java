package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Exercises10_DoubleClick {
    @Test
    public void exercises10(){
        WebDriver driver = AppUtils.getChromDriver();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();

        WebElement div = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));

        Actions actions = new Actions(driver);
        actions.doubleClick(div).perform();
    }
}
