package com.selenium.assignment3.core;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        File src = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("output//"+result.getTestClass()
                    +"_"+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
