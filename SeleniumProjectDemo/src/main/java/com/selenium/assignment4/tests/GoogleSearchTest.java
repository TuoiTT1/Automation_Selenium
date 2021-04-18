package com.selenium.assignment4.testes;

import com.selenium.assignment4.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest extends BaseTest{
    @BeforeTest
    @Parameters({ "platform", "browser"})
    public void setUp(String platform, String browser) throws MalformedURLException {
        System.out.println(platform + " - " + browser);

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set platform name
        if (platform.equalsIgnoreCase("windows")) {
            caps.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("mac")) {
            caps.setPlatform(Platform.MAC);
        }

        // Set browser name
        caps.setBrowserName(browser.toLowerCase());

        if (browser.equalsIgnoreCase("Chrome")) {
            /**
             * For headless chrome execution
             */
//            ChromeOptions opts = new ChromeOptions();
//            opts.addArguments("--headless");
//            caps.setCapability(ChromeOptions.CAPABILITY, opts);
        }

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

        this.setRemoteWebDriver(driver);
        this.getRemoteWebDriver().manage().window().maximize();
        this.getRemoteWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void firstTest() {
        System.out.println("First Test!!!");

        this.getRemoteWebDriver().navigate().to("http://www.google.com");
        String pageTitle = this.getRemoteWebDriver().getTitle();

        Assert.assertTrue(pageTitle.equalsIgnoreCase("Google"), "Verify page title is Google: FAILED"
                + " - [Actual]: " + pageTitle);
    }

    @Test
    public void secondTest() {
        System.out.println("Second Test!!!");

        GooglePage googleSearch = new GooglePage(this.getRemoteWebDriver());

        this.getRemoteWebDriver().navigate().to("http://www.google.com");
        this.getRemoteWebDriver().findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
        this.getRemoteWebDriver().findElement(By.name("q")).submit();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Cleaning up!!!");

        this.getRemoteWebDriver().quit();
    }
}
