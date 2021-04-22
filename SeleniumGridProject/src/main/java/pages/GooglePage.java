package pages;

import cores.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage extends BasePage {
    @FindBy(how = How.NAME, using = "q")
    private WebElement input_Search;

    public GooglePage(RemoteWebDriver driver) {
        super(driver);
    }

    public String navigateToPage(String url) {
        this.remoteWebDriver.navigate().to(url);

        return this.remoteWebDriver.getTitle();
    }

    public void searchText(String text) {
        this.input_Search.sendKeys(text);
        this.input_Search.submit();
    }
}
