package pages;

import cores.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBarPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//ul[@id='menu_1']/li/a[contains(text(), 'Warehouses')]")
    private WebElement warehouseLink;

    @FindBy(how = How.XPATH, using = "//ul[@id='menu_1']/li/a[contains(text(), 'Inventory')]")
    private WebElement inventoryLink;

    public NavigationBarPage(WebDriver driver) {
        super(driver);
    }

    public void clickWarehouse(){
        warehouseLink.click();
    }

    public void clickInventory(){
        inventoryLink.click();
    }
}
