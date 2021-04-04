package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Exercises7 {
    @Test
    public void exercises7() throws IOException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get(" http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        try {
            AppUtils.showPassOrFail("My Store".equals(driver.getTitle()));

            WebElement logo = driver.findElement(By.id("header_logo"));
            AppUtils.showPassOrFail(logo.isDisplayed());

            WebElement searchTextbox = driver.findElement(By.id("search_query_top"));
            WebElement searchButton = driver.findElement(By.xpath("//form[@id=\"searchbox\"]/button"));
            AppUtils.showPassOrFail(searchTextbox.isDisplayed() && searchButton.isDisplayed());

            searchTextbox.sendKeys("Faded Short Sleeve T-shirts");
            searchButton.click();

            WebElement result = driver.findElement(By.xpath("//div[@class=\"product-container\"]"));
            WebElement productName = result.findElement(By.xpath("//a[@class=\"product-name\" and contains(text(),\"Faded Short Sleeve T-shirts\")]"));
            Assert.assertEquals(productName.isDisplayed(), true, "Not found!");

            WebElement price = result.findElement(By.xpath("//div[@class=\"right-block\"]//span[@itemprop=\"price\" and contains(text(),\"$16.51\")]"));
            Assert.assertEquals(price.isDisplayed(), true, "Not found");

            result.findElement(By.xpath("//a[@class=\"product_img_link\"]")).click();

            WebElement quantity = driver.findElement(By.xpath("(//p[@id='quantity_wanted_p']/a)[2]"));
            quantity.click();
            quantity.click();

            driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();

            driver.findElement(By.xpath("//div[@class='button-container']/a")).click();

            WebElement table = driver.findElement(By.id("cart_summary"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", table);

            productName = table.findElement(By.xpath("//td[@class='cart_description']/p/a"));
            System.out.println(productName.getText());
            Assert.assertEquals(productName.getText(), "Faded Short Sleeve T-shirts", "Fail");

            price = table.findElement(By.xpath("//td[@class='cart_unit']/span/span"));
            System.out.println(price.getText());
            Assert.assertEquals(price.getText(), "$16.51", "Fail");

            quantity = table.findElement(By.name("quantity_1_1_0_0"));
            System.out.println(quantity.getAttribute("value"));
            Assert.assertEquals(quantity.getAttribute("value"), "3", "Fail");

            WebElement totalPrice = table.findElement(By.xpath("//span[@id='total_product_price_1_1_0' and contains(text(),'$49.53')]   "));
            System.out.println(totalPrice.isDisplayed());
            Assert.assertEquals(totalPrice.isDisplayed(), true, "Fail");

            AppUtils.takeScreenshot(driver, "exercises7");

        } finally {
            driver.close();
        }

    }
}
