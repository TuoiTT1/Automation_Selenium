package com.selenium.assignment4.tests;

import com.selenium.assignment4.core.BaseTest;
import com.selenium.assignment4.core.TestCase;
import com.selenium.assignment4.pages.LoginPage;
import com.selenium.assignment4.pages.WarehousePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WarehousePageTest extends BaseTest {
    private static List<TestCase> testCaseList = new ArrayList<>();

    @BeforeTest
    @Parameters({ "platform", "browser"})
    public void setUp(String platform, String browser) throws MalformedURLException {
        System.out.println(platform + " - " + browser);

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set platform name
        if (platform.equalsIgnoreCase("windows")) {
            caps.setPlatform(Platform.WINDOWS);
        }

        // Set browser name
        caps.setBrowserName(browser.toLowerCase());

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

        this.setRemoteWebDriver(driver);
        this.getRemoteWebDriver().manage().window().maximize();
        this.getRemoteWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void warehousePageTest(){
        LoginPage loginPage = new LoginPage(this.getRemoteWebDriver());
        loginPage.navigate("https://ce.scipioerp.com/facility/");
        if(loginPage.verifyLoginPage()){
            try {
                loginPage.login();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(loginPage.checkLoginSuccess()){
                WarehousePage warehousePage = new WarehousePage(this.getRemoteWebDriver());
                warehousePage.navigateToPage();
            }else {
                testCaseList.add(new TestCase("TC_01", "Verify Warehouses page", "Fail", "Login is fail"));
            }



        }else {
            testCaseList.add(new TestCase("TC_01", "Verify Warehouses page", "Fail", "Fail to navigate  login page"));
        }
    }
}
