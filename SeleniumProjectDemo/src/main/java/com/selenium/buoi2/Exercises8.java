package com.selenium.buoi2;

import com.selenium.utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Exercises8 {
    @Test
    public void exercises8() throws IOException {
        WebDriver driver = AppUtils.getChromDriver();
        driver.get(" http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        try {
            AppUtils.showPassOrFail("My Store".equals(driver.getTitle()));

            WebElement logo = driver.findElement(By.id("header_logo"));
            AppUtils.showPassOrFail(logo.isDisplayed());

            WebElement signIn = driver.findElement(By.xpath("//div[@class=\"header_user_info\"]/a[@class=\"login\"]"));
            AppUtils.showPassOrFail(signIn.isDisplayed());
            signIn.click();

            WebElement emailCreate = driver.findElement(By.id("email_create"));
            WebElement createAccBtn = driver.findElement(By.id("SubmitCreate"));
            Assert.assertEquals(emailCreate.isDisplayed() && createAccBtn.isDisplayed(), true, "Fail");

            emailCreate.sendKeys("exercises7@gmail.com");
            createAccBtn.click();

            driver.findElement(By.id("id_gender2")).click();
            driver.findElement(By.id("customer_firstname")).sendKeys("First");
            driver.findElement(By.id("customer_lastname")).sendKeys("Last");
            driver.findElement(By.id("passwd")).sendKeys("Exercises7");

            WebElement dayElm = driver.findElement(By.id("days"));
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView();", dayElm);

            Select select = new Select(dayElm);
            select.selectByValue("1");
            select = new Select(driver.findElement(By.id("months")));
            select.selectByValue("6");
            select = new Select(driver.findElement(By.id("years")));
            select.selectByValue("1996");

            driver.findElement(By.id("newsletter")).click();
            driver.findElement(By.id("company")).sendKeys("Company");
            driver.findElement(By.id("address1")).sendKeys("Cau Giay");
            driver.findElement(By.id("address2")).sendKeys("Thanh Tri");
            driver.findElement(By.id("city")).sendKeys("Ha Noi");

            select = new Select(driver.findElement(By.id("id_state")));
            select.selectByVisibleText("Ohio");
            driver.findElement(By.id("postcode")).sendKeys("99909");
            select = new Select(driver.findElement(By.id("id_country")));
            select.selectByIndex(1);

            driver.findElement(By.id("other")).sendKeys("AAAA");
            driver.findElement(By.id("phone")).sendKeys("0223456789");
            driver.findElement(By.id("phone_mobile")).sendKeys("0900034343");

            driver.findElement(By.id("submitAccount")).click();

            AppUtils.takeScreenshot(driver, "exercises8");



        } finally {
            driver.close();
        }

    }
}
