package com.selenium.assignment3.core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public void writeResult(String pathInput, String pathOutput, TestCase testCase, int rowIndex, int columIndex) throws IOException {
        File file = new File(pathOutput);
        if (!file.exists()) {
            FileUtils.copyFile(new File(pathInput), file);
        }
        ExcelUtils.writeExcel(testCase, file.getPath(), rowIndex, columIndex);
    }
}
