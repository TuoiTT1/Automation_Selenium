package pages;

import cores.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//ul[2]/li[2]/a")
    private WebElement loginInfo;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyLoginSuccessfully(){
        return this.loginInfo.isDisplayed();
    }

}
