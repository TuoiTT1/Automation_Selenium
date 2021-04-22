package pages;

import cores.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WarehousePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"menu_1\"]/li[5]/a")
    private WebElement warehouseLink;

    @FindBy(how = How.XPATH, using = "//div[@class=\"button-bar\"]/a")
    private WebElement createNewBtn;

    @FindBy(how = How.NAME, using = "facilityId_op")
    private WebElement warehouseID;

    @FindBy(how = How.NAME, using = "facilityId")
    private WebElement warehouseIDTextbox;

    @FindBy(how = How.NAME, using = "facilityName_op")
    private WebElement warehouseName;

    @FindBy(how = How.NAME, using = "parentFacilityId_op")
    private WebElement parentWarehouseID;

    @FindBy(how = How.NAME, using = "facilityTypeId")
    private WebElement warehouseType;

    @FindBy(how = How.NAME, using = "submitAction")
    private WebElement findBtn;

    @FindBy(how = How.XPATH, using = "//th[contains(text(), \"Warehouse ID\")]")
    private WebElement warehouseIDResult;

    @FindBy(how = How.XPATH, using = "//th[contains(text(), \"Warehouse Name\")]")
    private WebElement warehouseNameResult;

    @FindBy(how = How.XPATH, using = "//th[contains(text(), \"Warehouse Type\")]")
    private WebElement warehouseTypeResult;

    @FindBy(how = How.XPATH, using = "//th[contains(text(), \"Owner\")]")
    private WebElement ownerResult;

    @FindBy(how = How.XPATH, using = "//th[contains(text(), \"Area\")]")
    private WebElement areaResult;

    @FindBy(how = How.XPATH, using = "//th[contains(text(), \"Description\")]")
    private WebElement descriptionResult;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//table[@id=\"table_1\"]/tbody/tr")
    })
    private List<WebElement> searchResult;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//tr[@class=\"odd\"]/td")
    })
    private List<WebElement> firstSearchResult;

    @FindBy(how = How.XPATH, using = "//tr[@class=\"odd\"]/td/a")
    private WebElement warehouseIDResultFirstLink;

    @FindBy(how = How.NAME, using = "facilityTypeId")
    private WebElement facilityTypeId;

    @FindBy(how = How.NAME, using = "parentFacilityId")
    private WebElement parentFacilityId;

    @FindBy(how = How.NAME, using = "ownerPartyId")
    private WebElement ownerPartyId;

    @FindBy(how = How.NAME, using = "defaultWeightUomId")
    private WebElement defaultWeightUomId;

    @FindBy(how = How.NAME, using = "defaultInventoryItemTypeId")
    private WebElement defaultInventoryItemTypeId;

    @FindBy(how = How.NAME, using = "facilityName")
    private WebElement facilityName;

    @FindBy(how = How.NAME, using = "facilitySizeUomId")
    private WebElement facilitySizeUomId;

    @FindBy(how = How.NAME, using = "description")
    private WebElement description;

    @FindBy(how = How.NAME, using = "Update")
    private WebElement update;

    @FindBy(how = How.XPATH, using = "//div[@class=\"alert alert-danger\"]//li")
    private WebElement messageCreateFail;

    @FindBy(how = How.XPATH, using = "//div[@class=\"alert alert-danger\"]//li")
    private WebElement messageCreateSuccess;


    public WarehousePage(RemoteWebDriver driver) {
        super(driver);
    }


    public boolean verify() {
        return createNewBtn.isDisplayed() &&
                warehouseID.isDisplayed() &&
                warehouseName.isDisplayed() &&
                parentWarehouseID.isDisplayed() &&
                warehouseType.isDisplayed() &&
                findBtn.isDisplayed() &&
                warehouseIDResult.isDisplayed() &&
                warehouseNameResult.isDisplayed() &&
                warehouseTypeResult.isDisplayed() &&
                ownerResult.isDisplayed() &&
                areaResult.isDisplayed() &&
                descriptionResult.isDisplayed();
    }

    public void searchByWarehouseId(String key) {
        warehouseIDTextbox.sendKeys(key);
        findBtn.click();
    }

    public boolean verifySearchResult(String warehouseIdRsl, String warehouseNameRsl, String warehouseTypeRsl, String ownerRsl, String descriptionRsl) {
        if (searchResult.size() != 1) {
            return false;
        }
        return warehouseIdRsl.equals(firstSearchResult.get(0).findElement(By.tagName("a")).getText().trim()) &&
                warehouseNameRsl.equals(firstSearchResult.get(1).getText().trim()) &&
                warehouseTypeRsl.equals(firstSearchResult.get(2).getText().trim()) &&
                ownerRsl.equals(firstSearchResult.get(3).getText().trim()) &&
                descriptionRsl.equals(firstSearchResult.get(5).getText().trim());
    }

    public void clickCreateNew() {
        createNewBtn.click();
    }

    public void createNewWarehouse(String warehouseTypeID, String parentWarehouseID, String ownerPartyIdInp,
                                   String defaultWeightUnit, String inventoryItemType, String name,
                                   String areaUnit, String productDescription) {
        Select select = new Select(facilityTypeId);
        select.selectByVisibleText(warehouseTypeID);

        parentFacilityId.sendKeys(parentWarehouseID);
        ownerPartyId.sendKeys(ownerPartyIdInp);

        select = new Select(defaultWeightUomId);
        select.selectByVisibleText(defaultWeightUnit);

        defaultInventoryItemTypeId.sendKeys(inventoryItemType);

        facilityName.sendKeys(name);
        select = new Select(facilitySizeUomId);
        select.selectByVisibleText(areaUnit);

        description.sendKeys(productDescription);

        update.click();
    }

    public boolean verifyToCreate() {
        boolean value;
        try{
            value = !messageCreateFail.getText().contains("GenericValue");
            return value;
        }catch (NoSuchElementException e){
            return true;
        }
    }

    public void clickToFirstRsl() {
        warehouseIDResultFirstLink.click();
    }
}
