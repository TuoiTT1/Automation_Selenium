package cores;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver driver;
    private RemoteWebDriver remoteWebDriver;

    public static WebDriver getDriver() {
        return driver;
    }

    public RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriver;
    }

    public void setRemoteWebDriver(RemoteWebDriver driver) {
        remoteWebDriver = driver;
    }

//    @BeforeSuite
//    public void beforeSuite() {
//        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
//        driver = new ChromeDriver();
//    }

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

    @AfterTest
    public void afterSuite() {
        if (remoteWebDriver != null) {
            System.out.println("Cleaning up!!!");
            remoteWebDriver.quit();
        }
    }
}
