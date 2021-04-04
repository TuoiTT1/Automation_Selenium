package com.selenium.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class AppUtils {

    public static WebDriver getChromDriver(){
        System.setProperty("webdriver.chrome.driver",
                "driver\\chromedriver.exe");
        return new ChromeDriver();
    }
    
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("screenshot\\" + fileName + ".png"));
    }

    public static void showPassOrFail(boolean flag){
        if(flag){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}
