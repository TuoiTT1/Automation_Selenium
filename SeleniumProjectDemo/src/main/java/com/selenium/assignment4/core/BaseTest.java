package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.LoginPageTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    private static WebDriver driver;
    private RemoteWebDriver remoteWebDriver;

    public List<TestCase> testCaseList = new ArrayList<TestCase>();
//    @BeforeSuite
//    public void beforeSuite(){
//        System.setProperty("webdriver.chrome.driver","D:\\Training\\webdriver\\chromedriver87.exe");
//        driver = new ChromeDriver();
//    }
//
//    @AfterSuite
//    public void afterSuite(){
//        try {
//            if(testCaseList.size() > 0){
//                ExcelUtils.writeExcel(testCaseList,"D:\\testData.xlsx","data");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(null != driver){
//            driver.close();
//            driver.quit();
//        }
//    }

    public static WebDriver getDriver(){
        return driver;
    }

    public void setRemoteWebDriver(RemoteWebDriver driver) { remoteWebDriver = driver; }
    public RemoteWebDriver getRemoteWebDriver(){
        return remoteWebDriver;
    }
}
