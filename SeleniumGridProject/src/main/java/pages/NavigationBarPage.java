package pages;

import cores.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBarPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//ul[@id='menu_1']/li/a[contains(text(), 'Warehouses')]")
    private WebElement warehouseLink;

    @FindBy(how = How.XPATH, using = "//ul[@id='menu_1']/li/a[contains(text(), 'Inventory')]")
    private WebElement inventoryLink;

    @FindBy(how = How.XPATH, using = "//ul[@id='menu_1']/li/a[contains(text(), 'Settings')]")
    private WebElement settingsLink;

    @FindBy(how = How.XPATH, using = "//ul[@id='menu_6']/li/a[contains(text(), 'Contact Information')]")
    private WebElement contactInfoLink;

    public NavigationBarPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickWarehouse() {
        warehouseLink.click();
    }

    public void clickInventory() {
        inventoryLink.click();
    }

    public void clickSettings() {
        settingsLink.click();
    }

    public void clickContactInfo() {
        contactInfoLink.click();
    }
}
