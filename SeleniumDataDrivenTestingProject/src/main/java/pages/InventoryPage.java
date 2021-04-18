package pages;

import cores.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryPage extends BasePage {

    @FindBy(how = How.XPATH, using = "(//div[@class=\"button-bar\"]/a)[1]")
    private WebElement createNew;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_facilityId']")
    private WebElement warehouseIdLabel;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_datetimeReceived']")
    private WebElement SearchInventoryItemsParams_datetimeReceived;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_productId']")
    private WebElement SearchInventoryItemsParams_productId;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_internalName']")
    private WebElement SearchInventoryItemsParams_internalName;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_inventoryItemId']")
    private WebElement SearchInventoryItemsParams_inventoryItemId;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_statusId']")
    private WebElement SearchInventoryItemsParams_statusId;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_serialNumber']")
    private WebElement SearchInventoryItemsParams_serialNumber;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_softIdentifier']")
    private WebElement SearchInventoryItemsParams_softIdentifier;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_partyId']")
    private WebElement SearchInventoryItemsParams_partyId;

    @FindBy(how = How.XPATH, using = "//label[@for='SearchInventoryItemsParams_lotId']")
    private WebElement SearchInventoryItemsParams_lotId;

    @FindBy(how = How.NAME, using = "submitAction")
    private WebElement submitAction;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean verify(){
        return createNew.isDisplayed() &&
                warehouseIdLabel.isDisplayed() &&
                SearchInventoryItemsParams_datetimeReceived.isDisplayed() &&
                SearchInventoryItemsParams_productId.isDisplayed() &&
                SearchInventoryItemsParams_internalName.isDisplayed() &&
                SearchInventoryItemsParams_inventoryItemId.isDisplayed() &&
                SearchInventoryItemsParams_statusId.isDisplayed() &&
                SearchInventoryItemsParams_serialNumber.isDisplayed() &&
                SearchInventoryItemsParams_softIdentifier.isDisplayed() &&
                SearchInventoryItemsParams_partyId.isDisplayed() &&
                SearchInventoryItemsParams_lotId.isDisplayed() &&
                submitAction.isDisplayed();
    }
}
