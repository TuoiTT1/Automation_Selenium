package pages;

import cores.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

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

    //create new inventory
    @FindBy(how = How.NAME, using = "inventoryItemTypeId")
    private WebElement inventoryItemTypeId;

    @FindBy(how = How.NAME, using = "productId")
    private WebElement productId;

    @FindBy(how = How.NAME, using = "partyId")
    private WebElement partyId;

    @FindBy(how = How.NAME, using = "ownerPartyId")
    private WebElement ownerPartyId;

    @FindBy(how = How.NAME, using = "statusId")
    private WebElement statusId;

    @FindBy(how = How.NAME, using = "datetimeReceived_i18n")
    private WebElement datetimeReceived_i18n;

    @FindBy(how = How.NAME, using = "datetimeManufactured_i18n")
    private WebElement datetimeManufactured_i18n;

    @FindBy(how = How.NAME, using = "expireDate_i18n")
    private WebElement expireDate_i18n;

    @FindBy(how = How.NAME, using = "facilityId")
    private WebElement facilityId;

    @FindBy(how = How.NAME, using = "locationSeqId")
    private WebElement locationSeqId;

    @FindBy(how = How.NAME, using = "submit")
    private WebElement createInventory;

    //message
    @FindBy(how = How.XPATH, using = "//div[@class=\"alert alert-info\"]//li")
    private WebElement messageCreateInventory;

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

    public void clickCreateNew(){
        this.createNew.click();
    }

    public void inputCreate(String  inventoryItemTypeIDInp, String productIDInp, String  userIDInp,
                            String ownerPartyIDInp, String statusInp, String dateTimeReceivedInp,
                            String dateTimeManufacturedInp, String expireDateInp, String warehouseIDInp,
                            String warehouseLocationInp){
        Select select = new Select(inventoryItemTypeId);
        select.selectByVisibleText(inventoryItemTypeIDInp);

        productId.sendKeys(productIDInp);
        partyId.sendKeys(userIDInp);
        ownerPartyId.sendKeys(ownerPartyIDInp);

        select = new Select(statusId);
        select.selectByVisibleText(statusInp);

        datetimeReceived_i18n.sendKeys(dateTimeReceivedInp);
        datetimeManufactured_i18n.sendKeys(dateTimeManufacturedInp);
        expireDate_i18n.sendKeys(expireDateInp);

        select = new Select(facilityId);
        select.selectByVisibleText(warehouseIDInp);

        locationSeqId.sendKeys(warehouseLocationInp);

        createInventory.click();
    }

    public boolean verifyCreateNewInventory(){
        return messageCreateInventory.getText().contains("Operation has been executed successfully");
    }
}
